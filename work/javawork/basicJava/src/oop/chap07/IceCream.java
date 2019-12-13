package oop.chap07;

public class IceCream extends Dessert{
	private int calorie; 
	public IceCream() {
		
	}
	
	public IceCream(String productName, int price, int count, int calorie) {
		super(productName, price, count);
		this.calorie = calorie;
	}
	
	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	
	public static void print() {
		System.out.println("=============================");
		System.out.println("주문항목\t가격\t수량\t칼로리");
		System.out.println("=============================");
	}
	
	/*public void printProductInfo() {
		System.out.println(getProductName()+"\t"+getPrice()+"\t"+getCount()+"\t"+calorie);
	}*/
	
	public void printProductInfo() {
		super.printProductInfo();
		System.out.println("\t"+calorie+"kacl");
	}
	
}
