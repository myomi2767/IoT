package chap08;

public class Account {
	private String account;
	private int balance;
	private double interestRate;
	
	public Account() {
		
	}
	
	public Account(String account,int balance,double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public void setAccount(String account) {
		this.account=account;
	}
	public String getAccount() {
		return account;
	}
	
	public void setBalance(int balance) {
		this.balance=balance;
	}
	public int getBalance() {
		return balance;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate=interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public double calculateInterest() {
		double result = balance*interestRate/100;
		return result;
	}
	
	public void deposit (int money) throws Exception{
		if(money<0) {
			throw new Exception("입금 금액이 0보다 적습니다.");
		} else {
			balance += money;
		}
	}
	
	public void withdraw(int money) throws Exception{
		if(money<0 | balance<money) {
			throw new Exception();
		} else {
			balance -= money;
		}
		
	}
}
