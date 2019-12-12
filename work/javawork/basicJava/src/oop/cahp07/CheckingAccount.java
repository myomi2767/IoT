package oop.cahp07;

public class CheckingAccount extends Account {
	private String cardNo;
	public CheckingAccount() {
		
	}
	public CheckingAccount(String account,String ownerName,int balance,String cardNo) {
		super(account,ownerName,balance);
		this.cardNo = cardNo;
	}
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	//문자열비교는 무조건 equals를 이용해서 비교한다.
	//`==`는 안됨!
	public void pay(String cardNo,int amount) {
		if(this.cardNo.equals(cardNo) & getBalance()>=amount) {
			withdraw(amount);
		}else {
			System.out.println("지불이 불가능합니다.");
		}
	}
}
