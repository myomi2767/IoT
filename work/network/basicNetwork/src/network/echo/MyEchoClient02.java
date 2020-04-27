package network.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//바이너리데이터를 읽고 쓰지 않는 경우
public class MyEchoClient02 {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedReader keyin = null;
		try {
			socket = new Socket("70.12.115.63", 12345);
			System.out.println("서버접속완료..."+socket);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
				
			keyin = new BufferedReader(new InputStreamReader(System.in));
			
			String sendMsg = ""; //서버로 보낼 메시지
			String resMsg = ""; //서버로 받는 메시지
			resMsg = in.readLine();
			System.out.println(resMsg);
			while((sendMsg=keyin.readLine())!=null) {
				//1. 클라이언트 -> 서버(키보드로 입력하는 데이터를 서버로 전송)
				out.println(sendMsg);
				//2. 클라이언트 <- 서버
				resMsg = in.readLine();
				System.out.println(resMsg);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
