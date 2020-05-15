package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client { //Server가 한명의 클라이언트와 통신하기 위해 필요한 가능을 정의

	Socket socket; //통신을 위한
	public Client(Socket socket) {
		this.socket = socket;
		receive(); // 클라이언트로 부터 지속적으로 메세지를 전달 받도록
	}
	
	// 클라이언트로 부터 지속적으로 메세지를 전달 받도록 하는 메소드
	public void receive() {
		Runnable thread = new Runnable() {

			//하나의 스레드가 어떤 모듈로서 동작을 할것인지 정의
			@Override
			public void run() {
				try {
					while(true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						int length = in.read(buffer); // 문자열의 길이
						if(length == -1) throw new IOException();
						System.out.println("[메세지 수신 성공] " 
											+ socket.getRemoteSocketAddress() 
											+ ": "+ Thread.currentThread().getName());
						String message = new String(buffer,0,length,"UTF-8");
						for(Client client: Main.clients) { //클라이언트에게 받은 메세지를 다른 클라이언트들에게도 전달
							client.send(message);
						}
					}
				}catch(Exception e) {
					try {
						System.out.println("[메세지 수신 오류]" 
								+ socket.getRemoteSocketAddress() 
								+ ": "+ Thread.currentThread().getName());
						Main.clients.remove(Client.this);
						socket.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}
			
		};
		Main.threadPool.submit(thread); //Main의 threadpool에 스레드 저장 -> 안정적으로 관리
	}
	//클라이언트에게 메세지를 보내기 위한 메소드
	public void send(String message) {
		Runnable thread = new Runnable() {

			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer); //buffer에 담긴 내용을 서버에서 클라이언트로 전송
					out.flush();
				}catch(Exception e) {
					try {
						System.out.println("[메세지 송신 오류]" 
								+ socket.getRemoteSocketAddress() 
								+ ": "+ Thread.currentThread().getName());
						Main.clients.remove(Client.this); //오류가 발생하면 현재 존재하는 클라이언트를 제거(접속이 끊겼기 때문에)
						socket.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
			}
			
		};
		Main.threadPool.submit(thread);
	}
}
