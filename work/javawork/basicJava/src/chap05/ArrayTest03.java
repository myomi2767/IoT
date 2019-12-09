package chap05;

public class ArrayTest03 {
	public static void main(String[] args) {
		int[] myarr = new int[50];
		System.out.println(myarr[0]);
		System.out.println(myarr[1]);
		System.out.println(myarr[2]);
		System.out.println(myarr[3]);
		System.out.println(myarr[4]);
		//배열의 요소의 크기를 출력
		//length - 배열의 사이즈를 저장하고 있는 기본 변수(자동으로 제공되는)
		System.out.println("배열의 요소의 갯수:"+myarr.length);
		System.out.println("============================");
		for(int i=0;i<myarr.length;i++) {
			System.out.println(myarr[i]);
		}
		
	}

}
