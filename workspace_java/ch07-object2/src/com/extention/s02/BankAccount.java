package com.extention.s02;

public class BankAccount {
	protected String number;
	protected String password;
	protected String name;
	protected long balance;

	public BankAccount(String number, String password, String name, long balance) {
		this.number = number;
		this.password = password;
		this.name = name;
		this.balance = balance;

		System.out.println(number + " 계좌가 생성되었습니다.");
		System.out.println("----------------------");
	}

	// 입금
	public void deposite(long balance) {
		System.out.printf("%,d원 입금\n", balance);
		this.balance += balance;
		System.out.printf("%,d원 입금이 완료되었습니다.\n", balance);
		System.out.println("----------------------");
	}

	// 출금
	public void withdraw(long balance) {
		System.out.printf("%,d원 출금 시도\n", balance);
		// 잔고가 출금액이상이여야 출금가능
		if (this.balance <= balance) {
			System.out.println("잔고가 부족합니다");
			System.out.println("----------------------");
			return;
		}
		this.balance -= balance;
		System.out.printf("%,d원 출금이 완료되었습니다.\n", balance);
		System.out.println("----------------------");
	}
	
	//계좌 정보 출력
	public void printAccount() {
		System.out.println("일반 계좌 번호: " + number);
		System.out.println("계좌 비밀번호 : " + password);
		System.out.println("예금주 : " + name);
		System.out.println("잔고: " + balance);
		System.out.println("----------------------");
	}
	

}
