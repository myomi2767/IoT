package chap04;

public class ForExam03 {
	public static void main(String[] args) {
		int sum = 0; //УбЧе
		int sum2 = 0; //ШІМіЧе
		int sum3 = 0; //ТІМіЧе
		for(int i=1;i<=100;i++) {
			sum += i;
			if(i%2==1) {
				sum2 += i;
			} else {
				sum3 += i;
			}
		}
		System.out.println("Че :"+sum);
		System.out.println("ШІМі Че :"+sum2);
		System.out.println("ТІМі Че :"+sum3);
		/*sum=0;
		
		for(int j=1;j<=100;j+=2) {
			sum += j;
		}
		System.out.println("ШІМіЧе :"+sum);
		sum=0;
		
		for(int z=0;z<=100;z+=2) {
			sum += z;
		}
		System.out.println("ТІМіЧе :"+sum);*/
	}

}
