package chap09.API.lang;
//String클래스의 기본 메소드
public class StringTest02 {
	public static void main(String[] args) {
		String str1 = new String("java programming");
		String str2 = new String("재밌다.");
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println("str1.charAt(1)=>"+str1.charAt(1)); //1번째 요소의 글자 출력
		System.out.println("str1.concat(str2)=>"+str1.concat(str2));//합치는 것
		System.out.println("str1.indexOf('a')=>"+str1.indexOf('a')); // 앞에서 a의 위치
		System.out.println("str1.indexOf('합')=>"+str1.indexOf('합')); // 문자열에 없을 때 : -1
		System.out.println("str1.lastIndexOf('a')=>"+str1.lastIndexOf('a')); // 뒤에서 a의 위치
		System.out.println("str1.length()=>"+str1.length()); //문자길이
		
		//문자열비교 - 저오학하게 대소문자까지 비교
		System.out.println("str1.equals(\"java programming\")=>"+str1.equals("java programming"));
		System.out.println("str1.equals(\"Java programming\")=>"+str1.equals("Java programming"));
		
		//문자열비교  - 대소문자비교 안함
		System.out.println("str1.equalsIgnoreCase(\"java programming\")=>"
								+str1.equalsIgnoreCase("java programming"));
		System.out.println("str1.equalsIgnoreCase(\"Java programming\")=>"
								+str1.equalsIgnoreCase("Java programming"));
		//문자열비교 - prefix
		System.out.println("str1.startsWith(\"java\")=>"+str1.startsWith("java"));
		System.out.println("str1.startsWith(\"Java\")=>"+str1.startsWith("Java"));
		
		//문자열비교 - suffix
		System.out.println("str1.endsWith(\"ming\")=>"+str1.endsWith("ming"));

		
				
	}

}
