package com.instance.s04;

public class Account {
	private String account_num;
	private String name;
	private int balance;
	
	public Account(String a, String n, int b) {
		account_num = a;
		name = n;
		balance = b;
	}
	
	public String getAccount_Num() {
		return account_num;
	}
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	
	public void deposite(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		balance -= money;
	}
}
