package chap05;
//워크북 page 15. 문제8
public class ArrayExam02 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int sum = 0; //총합 저장할 변수
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
		}
		int avg = sum/arr.length; //평균 저장할 변수
		System.out.println("sum="+sum);
		System.out.println("avg="+avg);
	}

}
