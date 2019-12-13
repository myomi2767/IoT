package oop.chap07;

public class Staff extends Person{
	private String dept;
	public Staff() {
		
	}
	public Staff(String name, int age, String dept) {
		super(name,age);
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void print() {
		super.print();
		System.out.println(" ºÎ¼­: "+getDept());
	}
}
