package workbook;

public class AccountTest {
	public static void main(String[] args) {
		Account acc = new Account("441-0290-1203",500000,7.3);
		
		/*acc.setAccount("441-0290-1203");
		acc.setBalance(500000);
		acc.setInterestRate(7.3);*/
		System.out.println("계좌정보: "+acc.getAccount()+" 현재잔액: "+acc.getBalance());
		acc.deposit(20000);
		System.out.println("계좌정보: "+acc.getAccount()+" 현재잔액: "+acc.getBalance());
		System.out.println("이자: "+acc.calculateInterest());
		
	}
}
