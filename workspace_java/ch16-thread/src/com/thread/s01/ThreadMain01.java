package com.thread.s01;

//Thread Ŭ������ ��ӽ��� Thread �����ϱ�
public class ThreadMain01 extends Thread{
	
	//�����ڸ� ���ؼ� �������� �̸��� ����
	public ThreadMain01(String name) {
		super(name);
	}
	
	//Thread�� run() �޼ҵ� ������
	//Thread ��ü�� ������ �� �����ǵ� run�޼ҵ带 ȣ���ؼ� 
	//main�޼ҵ�� run�޼ҵ�� ���� �۾��� �����ϰ� ��. 
	@Override
	public void run() {//���� �۾�����
		for(int i=0;i<10;i++) {
			try {
				//������ �ð�(ms)��ŭ ������ ����
				sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("������ �̸�: " + currentThread().getName() + ", i = " + i);
		}
	}
	
	public static void main(String[] args) {
		ThreadMain01 tm = new ThreadMain01("ù��°");
		//start() �޼ҵ带 ȣ���ϸ� ������ ��ü�� run() �޼ҵ带 ȣ���ؼ�
		//main�޼ҵ�� ���ÿ� �۾��� ������ �� �ִ� ȯ���� ����.
		tm.start();
		
		
	}
}
