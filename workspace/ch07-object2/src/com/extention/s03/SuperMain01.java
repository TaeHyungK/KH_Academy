package com.extention.s03;

//�θ�Ŭ����
class Parent{
	int a = 100;
	public void play() {
		System.out.println("Parent�� play()");
	}
}

//�ڽ�Ŭ����
class Child extends Parent{
	int a=200;
	
	public Child() {
		// super�� �θ�Ŭ������ ��Ī�� �� �ֱ� ������ �θ�Ŭ������ ���� �Ǵ� �޼ҵ带 ȣ�� �� �� ���
		System.out.println(super.a);
		super.play();
		System.out.println("----------");
	}
	
	@Override
	public void play() {
		System.out.println("Child�� paly()");
	}
}
public class SuperMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);
		ch.play();
		
	}
}
