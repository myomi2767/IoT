package workbookHome;

public class Calc {
	public int calculate(int data) {
		int evenSum = 0;
		for(int i=0;i<=data;i++) {
			if(i%2==0) {
				evenSum += i;
			}
		}
		return evenSum;
	}
}
