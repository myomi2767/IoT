package oop.chap07.poly;
//객체의 형변환 - 상속관계에 있는 경우에만 가능하다.
class Parent{
	String name="장동건";
	public void display() {
		System.out.println("부모의 display");
	}
}

class Child extends Parent{
	String name="이민호";
	public void display() {
		System.out.println("자식클래스의 display");
	}
	public void test() {
		System.out.println("하위클래스에만 정의된 메소드");
	}
}

class Child2 extends Parent{
	
}
public class RefCastingTest {
	public static void main(String[] args) {
		System.out.println("1. super타입의 참조변수로 Super객체를 참조");
		Parent obj1 = new Parent();
		obj1.display();
		System.out.println(obj1.name);
		
		System.out.println("*********************************");
		System.out.println("2. sub타입의 참조변수로 sub객체를 참조");
		Child obj2 = new Child();
		obj2.display();
		System.out.println(obj2.name);
		
		/*
		 * 객체의 형변환
		 * - 변수는 참조변수타입에 따라 결정, 메소드는 생성되는 객체가 기준
		 */
		System.out.println("*********************************");
		System.out.println("3. super타입의 참조변수로 sub객체를 참조");
		Parent obj3 = new Child(); //자동형변환
		obj3.display(); //메소드 : 오버라이딩된 메소드라면 오버라이딩된 메소드가 호출
		System.out.println(obj3.name); //변수 : 참조변수 타입에 해당하는 클래스의 멤버변수가 실행
		
		//타입이 Parent타입이지만 실제로 생성된 객체가 Child타입이기 때문에 Child타입으로 형변환이 가능하다.(명시적)
		((Child)obj3).test();
		System.out.println("*********************************");
		System.out.println("4. sub타입의 참조변수로 super객체를 참조---X");
		//Child obj4 = new Parent();
		
		System.out.println("*********************************");
		System.out.println("5. sub타입의 참조변수 = super타입의 참조변수(Super객체를 참조)-----X");
		//명시적으로 형변환을 해서 컴파일러는 속였으나 실행시점에 캐스팅을 하려고 할때 
		//obj1이 Child정보를 갖고 있지 않으므로 캐스팅 예외 발생
		//Child obj5 = (Child)obj1;
		
		System.out.println("*********************************");
		System.out.println("6. sub타입의 참조변수 = super타입의 참조변수(sub객체를 참조)-----O");
		Child obj6 = (Child)obj3;
		System.out.println(obj6.name);
		obj6.display();
		obj6.test();
		
		
		Parent obj7 = obj2;
		
		Parent obj8=null; //교재의 car변수
		Child obj9=new Child();
		Child obj10 = null;
		
		obj8 = obj9; //super타입 = sub타입
		obj10 = (Child)obj8;
		
	}

}
