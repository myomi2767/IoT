package chap04;

public class WhileExam01 {
	public static void main(String[] args) {
		int i=1;
		int sum = 0;
		int evensum = 0;
		int oddsum = 0;
		
		while(i<=100) {
			sum += i;
			if(i%2==0) {
				evensum += i;
			}else {
				oddsum += i;
			}
			i++;
		}
		System.out.println("�� : "+sum);
		System.out.println("¦���� : "+evensum);
		System.out.println("Ȧ���� : "+oddsum);
	}

}
