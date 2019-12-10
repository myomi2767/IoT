package chap04;

import java.util.Scanner;

public class ScoreMultiExam {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = key.nextInt();
		if(score>=90 & score<=100) {
			System.out.println("A");
		}else if(score<90 & score>=80) {
			System.out.println("B");
		}else if(score<80 & score>=70) {
			System.out.println("C");
		}else if(score<70 & score>=60) {
			System.out.println("D");
		}else if(score<60 & score>=0) {
			System.out.println("F");
		}else {
			System.out.println("잘못입력");
		}
	}

}
