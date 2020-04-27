package single.console.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSenderThread extends Thread{
	Socket client;
	
	public ServerSenderThread(Socket client) {
		super();
		this.client = client;
	}

	public void run() {
		PrintWriter out = null;
		BufferedReader keyin = null;
		try {
			out = new PrintWriter(client.getOutputStream(),true);
			keyin = new BufferedReader(new InputStreamReader(System.in));
			
			String sendMsg = "";
			while(true) {
				sendMsg = keyin.readLine();
				if(sendMsg==null) {
					break;
				}
				out.println(sendMsg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
