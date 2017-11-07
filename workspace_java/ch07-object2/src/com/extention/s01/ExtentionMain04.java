package com.extention.s01;

//부모 클래스
class Parent2{
	int a=100;
	public void make() {
		System.out.println("오늘은 화요일!");
	}
}

//자식 클래스
class Child2 extends Parent2{
	int b=200;
	public void fun() {
		System.out.println("내일은 수요일!");
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
