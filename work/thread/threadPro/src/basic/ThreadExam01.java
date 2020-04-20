package basic;
/*
 * 쓰레드프로그래밍을 구현하세요
 *  - 1부터 100까지 출력 DigitThread
 *  - A~Z까지 출력하는 AlphaThread
 *  - ThreadExam01의 main메소드에서 DigitThread와 AlphaThread를 동시에 실행해보자.
 */
class DigitThread extends Thread{
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.print(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i%5==0) {
				System.out.println();
			}
		}
	}
}
class AlphaThread extends Thread{
	public void run() {
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class ThreadExam01 {
	public static void main(String[] args) {
		System.out.println("*****프로그램 시작*****");
		DigitThread d1 = new DigitThread();
		AlphaThread a1 = new AlphaThread();
		d1.start();
		a1.start();
		System.out.println("작업중........");
		for (int i = 1; i <= 10; i++) {
			System.out.print("main");
			try {
				Thread.sleep(200);//실행흐름을 멈춘다.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("*****프로그램 종료*****");
	}
}
