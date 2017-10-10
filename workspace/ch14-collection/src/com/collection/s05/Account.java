package com.collection.s05;

public class Account {
	private String account;
	private String name;
	private int balance;

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	//예금하기
	public void deposite(int balance) {
		this.balance += balance;
		System.out.println("입금 완료");
	}

	//출금하기
	public void withdraw(int balance) {
		if(this.balance >= balance) {
			this.balance -= balance;
			System.out.println("출금 완료");
		}else {
			System.out.println("잔고 부족");
		}
	}
}
