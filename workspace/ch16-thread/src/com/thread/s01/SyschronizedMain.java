package com.thread.s01;

class ATM implements Runnable{

	//공유자원
	private long depositeMoney = 10000;

	@Override
	public void run() {
		//동기화 블럭에는 하나의 Thread만 진입할 수 있고
		//Thread 작업이 끝난 후 빠져나가면 그 때 다른 Thread가 진입할 수 있음

		//         this: ATM을 가르킴
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

	//임계영역 : 공유자원을 참조하는 영역
	public void withdraw(long howMuch) {
		if(depositeMoney >= howMuch) {
			depositeMoney -= howMuch;
			System.out.println(Thread.currentThread().getName() + ": " + depositeMoney);
		}else {
			System.out.println(Thread.currentThread().getName() + ": 잔액이 부족합니다.");
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
