package oop.chap07;

final class FinalSuper{
	public final void display() {
		System.out.println("super display");
	}
}
class FinalSub extends FinalSuper{ //final클래스는 상속이 불가능
	static final int NUM = 100; // 상수는 대문자로!

	@Override //컴파일러에게 알려주기 위한 기호다.
	public void display() { //final메소드는 오버라이딩 할 수 없다.
		System.out.println("display");
	}
	
}
public class FinalTest {
	public static void main(String[] args) {
		FinalSub obj = new FinalSub();
		//obj.num = 1000; // 상수이므로 값을 수정할 수 없다.
		System.out.println(FinalSub.NUM);
		obj.display();
	}

}
