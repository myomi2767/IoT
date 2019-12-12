package oop.cahp07;

public class Account {
	private String account;
	private int balance;
	private String ownerName;
	private double interestRate;
	
	public Account() {
		
	}
	
	public Account(String account, String ownerName, int balance) {
		super();
		this.account = account;
		this.balance = balance;
		this.ownerName = ownerName;
	}

	/*public Account(String account,int balance,double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}*/
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		balance -= money;
	}
}
