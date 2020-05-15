package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client { //Server�� �Ѹ��� Ŭ���̾�Ʈ�� ����ϱ� ���� �ʿ��� ������ ����

	Socket socket; //����� ����
	public Client(Socket socket) {
		this.socket = socket;
		receive(); // Ŭ���̾�Ʈ�� ���� ���������� �޼����� ���� �޵���
	}
	
	// Ŭ���̾�Ʈ�� ���� ���������� �޼����� ���� �޵��� �ϴ� �޼ҵ�
	public void receive() {
		Runnable thread = new Runnable() {

			//�ϳ��� �����尡 � ���μ� ������ �Ұ����� ����
			@Override
			public void run() {
				try {
					while(true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						int length = in.read(buffer); // ���ڿ��� ����
						if(length == -1) throw new IOException();
						System.out.println("[�޼��� ���� ����] " 
											+ socket.getRemoteSocketAddress() 
											+ ": "+ Thread.currentThread().getName());
						String message = new String(buffer,0,length,"UTF-8");
						for(Client client: Main.clients) { //Ŭ���̾�Ʈ���� ���� �޼����� �ٸ� Ŭ���̾�Ʈ�鿡�Ե� ����
							client.send(message);
						}
					}
				}catch(Exception e) {
					try {
						System.out.println("[�޼��� ���� ����]" 
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
		Main.threadPool.submit(thread); //Main�� threadpool�� ������ ���� -> ���������� ����
	}
	//Ŭ���̾�Ʈ���� �޼����� ������ ���� �޼ҵ�
	public void send(String message) {
		Runnable thread = new Runnable() {

			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer); //buffer�� ��� ������ �������� Ŭ���̾�Ʈ�� ����
					out.flush();
				}catch(Exception e) {
					try {
						System.out.println("[�޼��� �۽� ����]" 
								+ socket.getRemoteSocketAddress() 
								+ ": "+ Thread.currentThread().getName());
						Main.clients.remove(Client.this); //������ �߻��ϸ� ���� �����ϴ� Ŭ���̾�Ʈ�� ����(������ ����� ������)
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
