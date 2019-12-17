package chap09.API.lang;

public class StringExam {
	public static void main(String[] args) {
		//str1을 AVAJ로 출력되도록 구현하세요
		//단, StringBuffer의 reverse()사용하지 않기
		//   String의 toCharArray()도 사용하지 않기
		//   String클래스의 charAt(0)과 toUpperCase() 이용하기
		String str1 = "java";
		
		//한 문자씩 출력하기
		for (int i = 0; i < str1.length(); i++) {
			System.out.print(str1.charAt(i));
		}
		System.out.println();
		
		//거꾸로 출력
		for (int i = str1.length()-1 ; i >= 0 ; i--) {
			System.out.print(str1.charAt(i));
		}
		System.out.println();
		
		String data = str1.toUpperCase();
		//대문자로 출력하기
		for (int i = data.length()-1 ; i >= 0 ; i--) {
			System.out.print(data.charAt(i));
		}
	}

}
