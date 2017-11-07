package com.thread.s01;

public class ThreadMain03 implements Runnable{

	@Override
	public void run() {
		System.out.println("run 메소드, 스레드이름: " + Thread.currentThread().getName());
	}
	
	
	public static void main(String[] args) {
		System.out.println("main 메소드, 스레드: " + Thread.currentThread().getName());
		
		//Runnable이 구현된 객체 생성
		ThreadMain03 tm = new ThreadMain03();
		//Thread객체 생성
		Thread t = new Thread(tm,"세번째");
		//start()메소드를 구동해서 Runnable이 구현된 객체의 run()메소드 호출
		t.start();
	}


}
