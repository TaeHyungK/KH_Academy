package com.thread.s01;

class ATM implements Runnable{

	//�����ڿ�
	private long depositeMoney = 10000;

	@Override
	public void run() {
		//����ȭ ������ �ϳ��� Thread�� ������ �� �ְ�
		//Thread �۾��� ���� �� ���������� �� �� �ٸ� Thread�� ������ �� ����

		//         this: ATM�� ����Ŵ
		synchronized (this) {
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}

				if(depositeMoney<= 0) {
					break;
				}

				withdraw(1000);
			}
		}
	}

	//�Ӱ迵�� : �����ڿ��� �����ϴ� ����
	public void withdraw(long howMuch) {
		if(depositeMoney >= howMuch) {
			depositeMoney -= howMuch;
			System.out.println(Thread.currentThread().getName() + ": " + depositeMoney);
		}else {
			System.out.println(Thread.currentThread().getName() + ": �ܾ��� �����մϴ�.");
		}
	}
}


public class SyschronizedMain {
	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		
		mother.start();
		son.start();
	}
}
