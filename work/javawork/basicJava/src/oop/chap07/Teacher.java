package oop.chap07;

public class Teacher extends Person{
	private String subject;
	public Teacher() {
		
	}
	public Teacher(String name, int age, String subject) {
		super(name,age);
		this.subject = subject;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void print() {
		super.print();
		System.out.println(" °ú¸ñ: "+getSubject());
	}
}
