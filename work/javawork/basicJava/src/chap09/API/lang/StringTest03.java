package chap09.API.lang;
//String클래스의 기본 메소드와 String클래스의 특징
//=> 문자열처리 메소드를  자주 호출하거나 +연산자로 문자열을 연결하는 작업이 많은 경우 String을 사용하지 않고
//   StringBuffer or String Builder를 이용한다.
public class StringTest03 {
	public static void main(String[] args) {
		String str1 = new String("java programming");
		String str2 = new String("재밌다.");
		
		//원본변환
		System.out.println("str1.toUpperCase()=>"+str1.toUpperCase());
		
		System.out.println("원본데이터:"+str1);
		
		System.out.println("str1.toLowerCase()=>"+str1.toLowerCase());
		System.out.println("str1.substring(2)=>"+str1.substring(2)); //2부터 전체 출력
		System.out.println("str1.substring(2,8)=>"+str1.substring(2,8)); 
		//2~7까지 출력, 2는 포함하고 8은 포함하지 않는다. 따라서 처음은 (index), 마지막은 (index-1)
		System.out.println("str1.replace('a', 'A')=>"+str1.replace('a', 'A'));
		
		System.out.println("원본데이터:"+str1);
		/* String을 조작하는 작업을 할 때마다 객체들이 많이 만들어진다.
		 * 따라서, 불특정다수가 사용하는 프로그램을 할 것이기 때문에 메모리에 문제가 생길 수 있으므로
		 * 문자열 조작이 빈번한 곳은 String을 쓰는 것은 옳지 않다.
		 * Buffer 는 동시접속에 대한 생각(Android) o
		 * Builder는 동시접속에 대한 생각(Web) x
		 */
	}

}
