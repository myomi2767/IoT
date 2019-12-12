package oop.cahp07;

import java.util.Scanner;

public class TestAccount {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		CheckingAccount acc1 = 
			new CheckingAccount("111-222-333","장동건"
					,1000000,"1234-5647-8888");
		System.out.println("카드번호입력:");
		String cardNo = key.next();
		acc1.pay("1234-5678-8888", 500000);
		System.out.println("현재잔액====>"+acc1.getBalance());
		acc1.pay(cardNo, 500000);//"1234-5647-8888"
		System.out.println("현재잔액====>"+acc1.getBalance());
		
	}

}
