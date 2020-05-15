package application;
	
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	public static ExecutorService threadPool; //���� Ŭ���̾�Ʈ�� ���������� ��������� ȿ�������� ������ �� �ֵ�����
	             // -> �������� �����带 ȿ�������� �����ϱ� ���� ����ϴ� ���̺귯�� (������Ǯ�� ����ϸ� ������ ������ ������ �ξ� ���ڱ� �������� Ŭ���̾�Ʈ�� ���� ���� ���� ���ϸ� ���� �� ����)
	public static Vector<Client> clients = new Vector<Client>(); //Ŭ���̾�Ʈ ������ ���� ����

	ServerSocket serverSocket;
	
	//������ �������Ѽ� Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ�
	public void startServer(String IP, int port) {
		try {
			serverSocket = new ServerSocket(); //���� ��ü Ȱ��ȭ
			serverSocket.bind(new InetSocketAddress(IP,port)); //���� ������ �ϴ� ��ǻ�Ͱ� �ڽ���  ip�ּ�, port��ȣ�� Ư�� Ŭ���̾�Ʈ�� ������ ��ٸ�������
		}
		catch(Exception e) {
			e.printStackTrace();
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		//Ŭ���̾�Ʈ�� ������ ������ ��� ��ٸ��� ������
		Runnable thread = new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();//Ŭ���̾�Ʈ ��ٸ��ٰ� �����ϸ�
						clients.add(new Client(socket)); //�ش�������� Ŭ���̾�Ʈ�� �ʱ�ȭ �� Ŭ���̾�Ʈ �迭�� ����
						System.out.println("[Ŭ���̾�Ʈ ����]" 
						+ socket.getRemoteSocketAddress() +": "
						+ Thread.currentThread().getName());
					}
					catch(Exception e) {
						if(!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					}
					
				}
			}
			
		};
		threadPool = Executors.newCachedThreadPool(); //threadpool �ʱ�ȭ
		threadPool.submit(thread);
	}
	
	//������ �۵��� ������Ű�� �޼ҵ�
	public void stopServer() {
		try {
			//���� �۵����� ��� ���� �ݱ�
			Iterator<Client> iterator = clients.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			//�������� �ݱ�
			if(serverSocket !=null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			
			//threadpool ����
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//UI�� �����ϰ� ���������� ���α׷��� ���۽�Ű�� �޼ҵ�
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane(); //�ٸ� ��ҵ��� ������ �ִ�
		root.setPadding(new Insets(5));
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false); // �����Ұ�
		textArea.setFont(new Font("�������",15));
		root.setCenter(textArea);
		
		Button toggleButton = new Button("�����ϱ�"); //����ġ ���� ���
		toggleButton.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setMargin(toggleButton, new Insets(1,0,0,0));
		root.setBottom(toggleButton);
		
		String IP = "127.0.0.1"; // local
		int port = 9876;
		
		toggleButton.setOnAction(event->{
			if(toggleButton.getText().equals("�����ϱ�")) {
				startServer(IP,port); //��ư�� ������ �� �ٷ� textArea�� ������ ������ �ϸ� �ȵȴ�
				Platform.runLater(()-> {
					String message = String.format("[��������]\n", IP,port);
					textArea.appendText(message);
					toggleButton.setText("�����ϱ�");
				});
			}else {
				stopServer();
				Platform.runLater(()-> {
					String message = String.format("[��������]\n", IP,port);
					textArea.appendText(message);
					toggleButton.setText("�����ϱ�");
				});
			}
		});
		
		Scene scene = new Scene(root, 400,400);//ũ�� ����
		primaryStage.setTitle("[ ä�� ���� ]");
		primaryStage.setOnCloseRequest(event-> stopServer());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//���α׷��� ������
	public static void main(String[] args) {
		launch(args);
	}
}
