package android.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import basic.SerialArduinoLEDTest;
//�ȵ���̵�(Ŭ���̾�Ʈ)�� ��û�� �޾Ƽ� �� �ȿ��� ��ġ ������ ��û�� �����ϴ� ����
public class AndroidLEDControlServer {
	private ServerSocket server;
	public void connect() {
		try {
			server = new ServerSocket(12345);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Thread th = new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Socket client = server.accept();
						String ip = client.getInetAddress().getHostAddress();
						System.out.println(ip+"���������!!\n");
						//Ŭ���̾�Ʈ�� ������ �޽����� �а� �ִ� ������
						new ReceiverThread(client).start();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		th.start();
	}
	public static void main(String[] args) {
		new AndroidLEDControlServer().connect();
	}

}