package com.thread.s01;

//Runnable 인터페이스를 이용한 Thread 생성
public class ThreadMain02 implements Runnable{
	
	//Runnable의 추상메소드를 구현
		@Override
		public void run() {	
			for(int i=0;i<10;i++) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("스레드 이름: " + Thread.currentThread().getName() + ", i = " + i);
			}
		}
		
	public static void main(String[] args) {
		ThreadMain02 tm = new ThreadMain02();
		//Runnable이 구현된 객체는 스레드 기능이 없기 때문에 
		//Thread 객체를 별도로 생성해서 Runnable이 구현된 객체의 run메소드를
		//실행해 주어야 병행 처리가 가능함.
		Thread t = new Thread(tm, "두번째");
		//start메소드는 Runnable이 구현된 객체의 run() 메소드 호출
		t.start();
		
	}

	
}
