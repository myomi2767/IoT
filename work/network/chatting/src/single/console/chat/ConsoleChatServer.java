package single.console.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleChatServer {
	public static void main(String[] args) {
		Socket client = null;
		
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버접속");
			while(true) {
				client = server.accept();
				InetAddress clientInfo = client.getInetAddress();
				System.out.println("접속한 클라이언트:"+clientInfo.getHostAddress());
				
				new ServerReceiveThread(client).start();
				new ServerSenderThread(client).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
