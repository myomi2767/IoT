package oop.chap06.constructor;

import java.io.File;
import java.io.FileInputStream;

//API의 클래스에 정의된 생성자메소드 확인하기
public class APIConstructorTest {
	public static void main(String[] args) throws Exception{
		byte[] data1 = {65,66,67,68,69};
		char[] data2 = {'a','b','c','d','e'};
		String str = new String();//String str = "";
		String str1 = new String("java");
		String str2 = new String(data1);
		String str3 = new String(data1,2,2);
		String str4 = new String(data2);
		
		System.out.println(str1+":"+str1.length());
		System.out.println(str2+":"+str2.length());
		System.out.println(str3+":"+str3.length());
		System.out.println(str4+":"+str4.length());
		
		File f = new File("test.txt");
		System.out.println(f.getName());
		
		FileInputStream fs = new FileInputStream("test.txt");
		System.out.println((char)fs.read());
		
		
	}

}
