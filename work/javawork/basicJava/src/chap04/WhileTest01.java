package chap04;
//while문 연습 - ForTest01.java.에서 작업한 내용을 while문으로 변경
//"자바프로그래밍" 5번 출력
public class WhileTest01 {
	public static void main(String[] args) {
		int i=1;
		while(i<=5) {
			System.out.println("자바프로그래밍"+i);
			i++; // i = i + 1
		}
		System.out.println("======================");
		i=1;
		while(true) {
			if(i>5) {
				//반복문을 빠져나가기
				break;
			}
			System.out.println("자바프로그래밍"+i);
			i++;
		}
	}

}
