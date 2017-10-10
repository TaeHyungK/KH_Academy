package com.thread.s01;

class MyRunnableOne implements Runnable{
	@Override
	public void run() {
		System.out.println("run");
		first();;
	}
	
	public void first() {
		System.out.println("first");
		second();
	}
	public void second() {
		System.out.println("second");
	}
	
}

public class ThreadMain05 {
	public static void main(String[] args) {
		//Runnable�� ������ ��ü ����
		MyRunnableOne m = new MyRunnableOne();
		
		Thread mThread = new Thread(m);
		mThread.start();
		try {
			//join() �޼ҵ�� ȣ���� ������(mThread)�� ����� ������
			//������ �����带 ��ٸ��� ��
			mThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " start");
		System.out.println(Thread.currentThread().getName() + " end");
	}
}
