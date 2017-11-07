package com.instance.s04;

import java.util.Scanner;

public class AccountMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account account = null;
		
		int money;
		
		while(true) {
			System.out.println("---------------------------------------------");
			System.out.println("1.���»��� | 2.�����ϱ� | 3.����ϱ� | 4.�������� | 5.����");
			System.out.println("---------------------------------------------");
			System.out.print("��ȣ ����> ");
			int num = input.nextInt();
			
			if(num==1) {//���»���
				System.out.print("���¹�ȣ �Է�: ");
				String mAccountNum = input.next();
				System.out.print("�̸� �Է�: ");
				String mName = input.next();
				
				account = new Account(mAccountNum,mName,0);
				System.out.println("���°� �����Ǿ����ϴ�.\n�ʱ� �ܰ�� 0���Դϴ�.");
			}else if(num==2) {//�����ϱ�
				if(account == null) {
					System.out.println("������ ���°� �����ϴ�.");
					continue;
				}else {
					System.out.print("�Ա��� �ݾ�: ");
					money = input.nextInt();
					account.deposite(money);
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				}
			}else if(num==3) {//����ϱ�
				if(account == null) {
					System.out.println("������ ���°� �����ϴ�.");
					continue;
				}else {
					System.out.print("����� �ݾ�: ");
					money = input.nextInt();
					account.withdraw(money);
					System.out.println("����� �Ϸ�Ǿ����ϴ�.");
				}
			}else if(num==4) {//�������� ��ȸ
				if(account == null) {
					System.out.println("������ ���°� �����ϴ�.");
					continue;
				}else {
					System.out.println("���¹�ȣ: "+ account.getAccount_Num());
					System.out.println("������: " + account.getName());
					System.out.println("���� �ݾ�: " + account.getBalance());
					
				}
			}else if(num==5) {
				System.out.println("�������α׷� ����");
				break;
			}else {
				System.out.println("1~5�� �Է����ּ���.");
			}
			
		}
	}
}
