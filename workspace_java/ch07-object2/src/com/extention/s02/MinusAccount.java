package com.extention.s02;

public class MinusAccount extends BankAccount{
	protected int minusLimit;

	public MinusAccount(String number, String password, String name, long balance, int minusLimit) {
		super(number, password, name, balance);
		this.minusLimit = minusLimit;
		
	}
	
	//출금 재정의 -> 마이너스 한도 적용
	@Override
	public void withdraw(long balance) {
		System.out.printf("%,d원 출금 시도\n", balance);
		if(this.balance <= balance - minusLimit) {
			System.out.println("한도를 초과하였습니다.");
			System.out.println("----------------------");
			return;
		}
		
		this.balance -= balance;
		System.out.printf("%,d원이 출금이 완료되었습니다.\n", balance);
		System.out.println("----------------------");
	}
	
	//계좌 정보 출력 재정의 -> 마이너스 계좌번호, 마이너 한도
	@Override
	public void printAccount() {
		System.out.println("마이너스 계좌 번호: " + number);
		System.out.println("계좌 비밀번호 : " + password);
		System.out.println("예금주 : " + name);
		System.out.println("잔고: " + balance);
		System.out.println("마이너 한도: " + minusLimit);
		System.out.println("----------------------");
	}
	
}
