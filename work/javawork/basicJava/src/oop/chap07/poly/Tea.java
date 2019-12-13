package oop.chap07.poly;

public class Tea extends Beverage{
	static int amount;
	public Tea() {
		
	}
	public Tea(String name) { //Tea가 판매
		super(name);
		amount++;
		calcPrice();
		//주문되는 읨료의 가격을 계산
	}

	public void calcPrice() {
		if(getName().equals("lemonTea")) {
			setPrice(1500);
			
		}else if(getName().equals("ginsengTea")) {
			setPrice(2000);
			
		}else if(getName().equals("redginsengTea")) {
			setPrice(2500);
			
		}
	}
	public static int getAmount() {
		return amount;
	}
	
}
