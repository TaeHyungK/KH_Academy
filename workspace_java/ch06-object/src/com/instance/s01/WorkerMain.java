package com.instance.s01;
class Worker{
	String name;
	int money;
	int balance;
	
	public void work() {
		money += 1000;
	}
	
	public void deposite() {
		balance += money;
		money = 0;
	}
}
public class WorkerMain {
	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.name = "ȫ�浿";
		
		//10�� ���ϴµ� 3000���� �� ���� ����
		for(int i=1;i<=10;i++) {
			worker.work();
			if(worker.money >= 3000) {
				worker.deposite();
			}
		}
		//���� �̸� ���
		System.out.println("���� �̸�: "+worker.name);
		//���� �Աݵ��� �ʴ� �޿�(���߿� �ִ� ��) ���
		System.out.printf("�Աݵ��� ���� �޿�: %,d��\n", worker.money);
		//������ �ܰ� ���
		System.out.printf("������ �ܰ�: %,d��\n",worker.balance);
	}
}

