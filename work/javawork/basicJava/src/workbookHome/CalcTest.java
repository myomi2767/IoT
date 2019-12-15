package workbookHome;

public class CalcTest {

	public static void main(String[] args) {
		int data = Integer.parseInt(args[0]);
		Calc c1 = new Calc();
		if (data>=5 & data<=10) {
			int sum = c1.calculate(data);
			System.out.println("결과: "+sum);
		}else {
			System.out.println("다시 입력하세요");
		}
	}

}
