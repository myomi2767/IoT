package oop.chap06.constructor;
//매소드의 호출 과정
public class MethodcallExam {
	public void test() {
		first();
	}
	public void first() {
		second();
	}
	public void second() {
		System.out.println("second()~~~");
	}
	public static void main(String[] args) {
		MethodcallExam obj = new MethodcallExam();
		obj.test();
	}
}
