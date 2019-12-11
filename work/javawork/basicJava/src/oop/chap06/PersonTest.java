package oop.chap06;
//Person클래스를 사용하는 클래스
public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person("장동건","서울시",45);
		/*p1.setName("장동건");
		p1.setAddr("서울시");
		p1.setAge(45);*/ //age변수는 private으로 선언되어 있으므로 같은 패키지의 클래스에서도 접근할 수 없다.
		System.out.println("성명:"+p1.getName());
		System.out.println("주소:"+p1.getAddr());
		System.out.println("나이:"+p1.getAge());
		
		Person p2 = new Person("김서연","인천시",25);
		/*p2.setName("김서연");
		p2.setAddr("인천시");
		p2.setAge(25);*/
		System.out.println("성명:"+p2.getName());
		System.out.println("주소:"+p2.getAddr());
		System.out.println("나이:"+p2.getAge());
	}

}
