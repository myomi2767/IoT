package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class MyNetServer03 {
	public static void main(String[] args) {
		Socket client = null;
		InputStream is = null;
		DataInputStream dis = null;
		OutputStream os = null; 
		DataOutputStream dos = null;
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버준비완료.... 클라이언트의 접속을 기다림");
			
			while(true) {
				client = server.accept();
				InetAddress clientInfo = client.getInetAddress();
				System.out.println("접속한 클라이언트:"+clientInfo.getHostAddress());
				
				is = client.getInputStream();
				dis = new DataInputStream(is);
				
				os = client.getOutputStream();
				dos = new DataOutputStream(os);
				
				//1. 서버 -> 클라이언트(순서가 중요... output을 연속으로 두번)
				dos.writeUTF("안녕하세요. 클라이언트님");
				Random random = new Random();
				dos.writeInt(random.nextInt(8)+2);
				
				//2. 서버 <- 클라이언트
				String data = dis.readUTF();
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
 