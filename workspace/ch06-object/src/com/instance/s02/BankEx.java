package com.instance.s02;

class Account{
	//�������
	String account_num; //���¹�ȣ
	String name; //������
	int balance; //�ܰ�
	
	//�޼ҵ�
	//��������
	public void deposite(int money) {
		balance += money;
	}
	//����ϱ�
	public void withdraw(int money) {
		balance -= money;
	}
	//��������
	public void pirntAccount() {
		System.out.println("���� ��ȣ: " + account_num);
		System.out.println("������: "+ name);
		System.out.printf("�ܰ�: %,d��\n",balance);
	}
}

public class BankEx {
	public static void main(String[] args) {
		//���� ����
		Account account = new Account();
		//���� �⺻ ������ �Է�
		account.account_num = "848-868-46";
		account.name = "ȫ�浿";
		account.balance = 0;
		
		//�Ա�
		account.deposite(3000);
		//�������� ���
		account.pirntAccount();
		System.out.println("------------------");
		//���
		account.withdraw(2000);
		//�������� ���
		account.pirntAccount();
	}
}
