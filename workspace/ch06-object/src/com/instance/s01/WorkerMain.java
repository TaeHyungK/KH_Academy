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
		worker.name = "홍길동";
		
		//10번 일하는데 3000원일 때 마다 저축
		for(int i=1;i<=10;i++) {
			worker.work();
			if(worker.money >= 3000) {
				worker.deposite();
			}
		}
		//직원 이름 출력
		System.out.println("직원 이름: "+worker.name);
		//현재 입금되지 않는 급여(수중에 있는 돈) 출력
		System.out.printf("입금되지 않은 급여: %,d원\n", worker.money);
		//통장의 잔고 출력
		System.out.printf("통장의 잔고: %,d원\n",worker.balance);
	}
}

