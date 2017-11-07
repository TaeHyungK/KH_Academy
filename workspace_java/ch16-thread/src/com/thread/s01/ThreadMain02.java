package com.thread.s01;

//Runnable �������̽��� �̿��� Thread ����
public class ThreadMain02 implements Runnable{
	
	//Runnable�� �߻�޼ҵ带 ����
		@Override
		public void run() {	
			for(int i=0;i<10;i++) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("������ �̸�: " + Thread.currentThread().getName() + ", i = " + i);
			}
		}
		
	public static void main(String[] args) {
		ThreadMain02 tm = new ThreadMain02();
		//Runnable�� ������ ��ü�� ������ ����� ���� ������ 
		//Thread ��ü�� ������ �����ؼ� Runnable�� ������ ��ü�� run�޼ҵ带
		//������ �־�� ���� ó���� ������.
		Thread t = new Thread(tm, "�ι�°");
		//start�޼ҵ�� Runnable�� ������ ��ü�� run() �޼ҵ� ȣ��
		t.start();
		
	}

	
}
