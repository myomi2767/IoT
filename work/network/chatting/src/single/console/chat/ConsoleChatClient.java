package single.console.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConsoleChatClient {
	public static void main(String[] args) {
		Socket socket = null;
		
			try {
				socket = new Socket("70.12.115.64", 12345);
				System.out.println("서버접속완료..."+socket);
				new ClientSenderThread(socket).start();
				new ClientReceiveThread(socket).start();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
