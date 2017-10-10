package com.instance.s02;

class Account{
	//멤버변수
	String account_num; //계좌번호
	String name; //예금주
	int balance; //잔고
	
	//메소드
	//예금히기
	public void deposite(int money) {
		balance += money;
	}
	//출금하기
	public void withdraw(int money) {
		balance -= money;
	}
	//계좌정보
	public void pirntAccount() {
		System.out.println("계좌 번호: " + account_num);
		System.out.println("예금주: "+ name);
		System.out.printf("잔고: %,d원\n",balance);
	}
}

public class BankEx {
	public static void main(String[] args) {
		//계좌 생성
		Account account = new Account();
		//계좌 기본 정보를 입력
		account.account_num = "848-868-46";
		account.name = "홍길동";
		account.balance = 0;
		
		//입금
		account.deposite(3000);
		//계좌정보 출력
		account.pirntAccount();
		System.out.println("------------------");
		//출금
		account.withdraw(2000);
		//계좌정보 출력
		account.pirntAccount();
	}
}
