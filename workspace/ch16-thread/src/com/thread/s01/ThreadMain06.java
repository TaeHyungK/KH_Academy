package com.thread.s01;

class ThreadEx01 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
		}
	}
}

class ThreadEx02 extends Thread{

	@Override
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
		}
	}
}

public class ThreadMain06{
	public static void main(String[] args) {
			ThreadEx01 te01 = new ThreadEx01();
			ThreadEx02 te02 = new ThreadEx02();
			
			//�켱������ ������ ���� start�޼ҵ带 ȣ���ϱ� ���� �����ؾ���.
			te02.setPriority(8);
			
			System.out.println("Priority of te01(-): "+ te01.getPriority());
			System.out.println("Priority of te02(|): "+ te02.getPriority());
			
			te01.start();
			te02.start();
			
	}
}
