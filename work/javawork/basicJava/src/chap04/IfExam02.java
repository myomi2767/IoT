package chap04;
//if문을  중첩해서 사용하는 연습 - gender와 age를 판단해서 결과를 출력하는 예제
import java.util.Scanner;
//Ctrl+Shift+f => 코드를 정리해준다.
public class IfExam02 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.print("성별을 입력하세요 :");
		int sex = key.nextInt();
/*		if(sex<1 | sex>4) {
			System.out.print("숫자를 잘못 입력");
		} else {
			System.out.Print("나이를 입력하세요 : ");
			int age = key.nextInt();
			// 나이에 관한 거 작성
		}*/
		System.out.print("나이를 입력하세요 :");
		int age = key.nextInt();
		if(sex>0 & sex<=4) {
			if(sex==1 | sex==3) {
				if(age<=19) {
					System.out.println("청소년남자");
				}else {
					System.out.println("성인남자");
				}
			}else {
				if(age<=19) {
					System.out.println("청소년여자");
				}else {
					System.out.println("성인여자");
				}
			
			}
		}
	}

}
