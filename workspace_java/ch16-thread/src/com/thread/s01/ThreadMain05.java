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
		//Runnable이 구현된 객체 생성
		MyRunnableOne m = new MyRunnableOne();
		
		Thread mThread = new Thread(m);
		mThread.start();
		try {
			//join() 메소드는 호출한 스레드(mThread)가 종료될 때까지
			//현재의 스레드를 기다리게 함
			mThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " start");
		System.out.println(Thread.currentThread().getName() + " end");
	}
}
