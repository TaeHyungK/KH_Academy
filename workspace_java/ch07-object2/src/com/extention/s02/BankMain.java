package com.extention.s02;

public class BankMain {
	public static void main(String[] args) {
		BankAccount normal = new BankAccount("1470", "1234", "홍길동", 100);
		normal.printAccount();
		normal.deposite(100);
		normal.withdraw(50);
		normal.printAccount();
		normal.withdraw(500);
		normal.printAccount();
		
		MinusAccount minus = new MinusAccount("1682", "0001", "아무개", 500, 100);
		minus.printAccount();
		minus.deposite(20);
		minus.withdraw(60);
		minus.printAccount();
		minus.withdraw(30);
		minus.printAccount();
		minus.withdraw(500);
		minus.printAccount();
	}
}
