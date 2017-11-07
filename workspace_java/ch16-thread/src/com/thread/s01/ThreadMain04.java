package com.thread.s01;

public class ThreadMain04 extends Thread{	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(i+"번 박수쳐!!");
		}
	}

	public static void main(String[] args) {
		ThreadMain04 tm = new ThreadMain04();
		tm.start();
		
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i+"번 노래 불러~~!");
		}
	}
}
