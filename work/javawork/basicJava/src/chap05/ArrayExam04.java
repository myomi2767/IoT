package chap05;
// 워크북 page 14. 문제7
public class ArrayExam04 {
	public static void main(String[] args) {
		int sum = 0;
		int num1 = Integer.parseInt(args[0]);
		int[] myarr = new int[100];
		System.out.println("입력 예1:"+args[0]);
		
		for(int i=1;i<=100;i++) {
			if(i%num1==0) {
				sum += i;
				System.out.print(i+"+");
			}
		}
		
		System.out.println("="+sum);
	}

}
