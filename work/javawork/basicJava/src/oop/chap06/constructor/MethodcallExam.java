package oop.chap06.constructor;
//�żҵ��� ȣ�� ����
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