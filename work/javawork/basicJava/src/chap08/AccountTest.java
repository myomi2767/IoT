package chap08;

public class AccountTest {
	public static void main(String[] args) {
		Account acc = new Account("441-0290-1203",500000,7.3);
		
		/*acc.setAccount("441-0290-1203");
		acc.setBalance(500000);
		acc.setInterestRate(7.3);*/
		System.out.println("계좌정보: "+acc.getAccount()+" 현재잔액: "+acc.getBalance());
		try {
			acc.deposit(-10);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			acc.withdraw(600000);
		}catch(Exception e) {
			System.out.println("금액이 0보다 적거나 현재 잔액보다 많습니다.");
		}

		System.out.println("이자: "+acc.calculateInterest());
		
	}
}
