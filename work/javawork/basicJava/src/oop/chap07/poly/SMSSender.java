package oop.chap07.poly;
public class SMSSender extends Sender {
	int length;
	public SMSSender(String name,int length){
		super(name);
		this.length = length;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void print() {
		//SMSSender의 고유 기능을 실행
		System.out.println(length+"로 "+name+" 전송완료");
	}
}
