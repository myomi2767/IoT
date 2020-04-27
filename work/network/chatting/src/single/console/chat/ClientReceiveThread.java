package single.console.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientReceiveThread extends Thread{
	Socket socket;
	
	public ClientReceiveThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String resMsg = "";
			while(true) {
				resMsg = in.readLine();
				if(resMsg==null) {
					break;
				}
				System.out.println("서버>>"+resMsg);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
