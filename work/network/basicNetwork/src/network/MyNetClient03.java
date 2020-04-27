package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient03 {
	public static void main(String[] args) {
			Socket socket;
			InputStream is = null;
			DataInputStream dis = null;
			OutputStream os = null; 
			DataOutputStream dos = null;
			try {
				socket = new Socket("70.12.115.63", 12345);
				
				is = socket.getInputStream();
				dis = new DataInputStream(is);
				
				os = socket.getOutputStream();
				dos = new DataOutputStream(os);
				
				//1. 클라이언트 <- 서버(서버가 보내는 데이터를 읽기 - 2번 연속해서 읽기)
				String data = dis.readUTF();
				System.out.println(data);
				
				int gugu = dis.readInt();
				for(int i=1;i<=9;i++) {
					System.out.println(gugu+"*"+i+"="+gugu*i);
				}
				//2. 클라이언트 -> 서버 
				if(gugu%2==0) {
					dos.writeUTF("짝수");
				}else {
					dos.writeUTF("홀수");
				}
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
