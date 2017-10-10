package com.thread.s01;

//Thread 클래스를 상속시켜 Thread 생성하기
public class ThreadMain01 extends Thread{
	
	//생성자를 통해서 스레드의 이름을 지정
	public ThreadMain01(String name) {
		super(name);
	}
	
	//Thread의 run() 메소드 재정의
	//Thread 객체가 생성된 후 재정의된 run메소드를 호출해서 
	//main메소드와 run메소드는 동시 작업을 수행하게 됨. 
	@Override
	public void run() {//세부 작업단위
		for(int i=0;i<10;i++) {
			try {
				//지정된 시간(ms)만큼 수행을 멈춤
				sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("스레드 이름: " + currentThread().getName() + ", i = " + i);
		}
	}
	
	public static void main(String[] args) {
		ThreadMain01 tm = new ThreadMain01("첫번째");
		//start() 메소드를 호출하면 스레드 객체는 run() 메소드를 호출해서
		//main메소드와 동시에 작업을 수행할 수 있는 환경을 만듦.
		tm.start();
		
		
	}
}
