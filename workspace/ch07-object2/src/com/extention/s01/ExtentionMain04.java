package com.extention.s01;

//�θ� Ŭ����
class Parent2{
	int a=100;
	public void make() {
		System.out.println("������ ȭ����!");
	}
}

//�ڽ� Ŭ����
class Child2 extends Parent2{
	int b=200;
	public void fun() {
		System.out.println("������ ������!");
	}
}

public class ExtentionMain04 {
	public static void main(String[] args) {
		Child2 c = new Child2();
		c.make();
		c.fun();
		System.out.println(c.a);
		System.out.println(c.b);
	}
}
