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

		System.out.println(number + " ���°� �����Ǿ����ϴ�.");
		System.out.println("----------------------");
	}

	// �Ա�
	public void deposite(long balance) {
		System.out.printf("%,d�� �Ա�\n", balance);
		this.balance += balance;
		System.out.printf("%,d�� �Ա��� �Ϸ�Ǿ����ϴ�.\n", balance);
		System.out.println("----------------------");
	}

	// ���
	public void withdraw(long balance) {
		System.out.printf("%,d�� ��� �õ�\n", balance);
		// �ܰ� ��ݾ��̻��̿��� ��ݰ���
		if (this.balance <= balance) {
			System.out.println("�ܰ� �����մϴ�");
			System.out.println("----------------------");
			return;
		}
		this.balance -= balance;
		System.out.printf("%,d�� ����� �Ϸ�Ǿ����ϴ�.\n", balance);
		System.out.println("----------------------");
	}
	
	//���� ���� ���
	public void printAccount() {
		System.out.println("�Ϲ� ���� ��ȣ: " + number);
		System.out.println("���� ��й�ȣ : " + password);
		System.out.println("������ : " + name);
		System.out.println("�ܰ�: " + balance);
		System.out.println("----------------------");
	}
	

}
