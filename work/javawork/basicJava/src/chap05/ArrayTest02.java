package chap05;

import java.util.Random;
import java.util.Scanner;

//참조형데이터 배열 만들기
public class ArrayTest02 {
	public static void main(String[] args) {
		String[] strArr = new String[3];
		Random[] ranArr = new Random[5];
		Scanner[] keyArr = new Scanner[100];
		
		//참조형 배열변수의 초기값은 null
		//null은 아무것도 참조 하지 않는다는 의미
		System.out.println(strArr[0]);
		System.out.println(ranArr[0]);
		System.out.println(keyArr[0]);
		
		//참조형 배열의 선언과 생성의 초기화
		String[] arr = new String[3];
		arr[0] = new String("java");
		arr[1] = new String("JDBC");
		arr[2] = new String("HTML5");
		System.out.println(arr[0]);
		
		//ranArr의 초기화
		ranArr[0] = new Random();
		ranArr[1] = new Random();
		
		for(int i = 0; i<ranArr.length;i++) {
			System.out.println(ranArr[i]);
		}
	}

}
