package chap03;

import java.util.Random;

public class APIExam {
	public static void main(String[] args) {
		Random ran = new Random();
		int result = ran.nextInt();
		System.out.println("랜덤값=>"+result);

		//1에서 100사이의 랜덤값 출력
		result = ran.nextInt(100)+1;
		System.out.println(result);
		
	}

}
