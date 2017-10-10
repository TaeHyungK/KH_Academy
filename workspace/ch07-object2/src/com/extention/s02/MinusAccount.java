package com.extention.s02;

public class MinusAccount extends BankAccount{
	protected int minusLimit;

	public MinusAccount(String number, String password, String name, long balance, int minusLimit) {
		super(number, password, name, balance);
		this.minusLimit = minusLimit;
		
	}
	
	//��� ������ -> ���̳ʽ� �ѵ� ����
	@Override
	public void withdraw(long balance) {
		System.out.printf("%,d�� ��� �õ�\n", balance);
		if(this.balance <= balance - minusLimit) {
			System.out.println("�ѵ��� �ʰ��Ͽ����ϴ�.");
			System.out.println("----------------------");
			return;
		}
		
		this.balance -= balance;
		System.out.printf("%,d���� ����� �Ϸ�Ǿ����ϴ�.\n", balance);
		System.out.println("----------------------");
	}
	
	//���� ���� ��� ������ -> ���̳ʽ� ���¹�ȣ, ���̳� �ѵ�
	@Override
	public void printAccount() {
		System.out.println("���̳ʽ� ���� ��ȣ: " + number);
		System.out.println("���� ��й�ȣ : " + password);
		System.out.println("������ : " + name);
		System.out.println("�ܰ�: " + balance);
		System.out.println("���̳� �ѵ�: " + minusLimit);
		System.out.println("----------------------");
	}
	
}
