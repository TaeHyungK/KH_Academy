package com.thread.s01;

public class ThreadMain03 implements Runnable{

	@Override
	public void run() {
		System.out.println("run �޼ҵ�, �������̸�: " + Thread.currentThread().getName());
	}
	
	
	public static void main(String[] args) {
		System.out.println("main �޼ҵ�, ������: " + Thread.currentThread().getName());
		
		//Runnable�� ������ ��ü ����
		ThreadMain03 tm = new ThreadMain03();
		//Thread��ü ����
		Thread t = new Thread(tm,"����°");
		//start()�޼ҵ带 �����ؼ� Runnable�� ������ ��ü�� run()�޼ҵ� ȣ��
		t.start();
	}


}
