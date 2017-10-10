package com.extention.s04;

class Car{
	String color;
	int door;
	
	public void drive() {
		System.out.println("drive!!");
	}
	public void stop() {
		System.out.println("stop!!");
	}
	public void getPower() {
		System.out.println("���� �ڵ���!!");
	}
}

class FireEngine extends Car{
	
	public void water() {
		System.out.println("water!!");
	}
	@Override
	public void getPower() {
		System.out.println("�ҹ漳�� ���� �ڵ���!!");
	}
}


public class PolyMain04 {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		fe.drive();//Car�� drive()
		fe.stop();//Car�� stop()
		fe.water();//FireEngine�� water()
		fe.getPower();//FireEngine�� getPower()
		System.out.println("--------------------");
		
		//�ڽ�Ŭ���� Ÿ�� -> �θ�Ŭ���� Ÿ��
		//��ĳ����, �ڵ� ����ȯ
		Car c = fe;
		c.drive();
		c.stop();
		//ȣ�� ������ ��� ȣ�� �Ұ�
//		c.water()
		c.getPower();//FireEngine�� getPower()�� ȣ����.
		
	}
}
