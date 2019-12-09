package chap04;
//cnotinue - 선언된 위치 아래의 코드를 skip하기 위해 사용
public class GuGu_Continue {
	public static void main(String[] args) {
		for(int row=2;row<=9;row++) {
			if(row==5) {
				continue;
			}
			for(int i=1;i<=9;i++) {
				/*if(row==5) { break문이 내부 for에 선언되어 있으므로 반복문이 종료되지는 않는다.
					break;
				}*/
				System.out.print(row+"*"+i+"="+i*row+"\t");
			}
			System.out.println();
		}
	}

}
