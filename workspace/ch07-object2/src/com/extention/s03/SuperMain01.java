package com.extention.s03;

//부모클래스
class Parent{
	int a = 100;
	public void play() {
		System.out.println("Parent의 play()");
	}
}

//자식클래스
class Child extends Parent{
	int a=200;
	
	public Child() {
		// super는 부모클래스를 지칭할 수 있기 때문에 부모클래스의 변수 또는 메소드를 호출 할 때 사용
		System.out.println(super.a);
		super.play();
		System.out.println("----------");
	}
	
	@Override
	public void play() {
		System.out.println("Child의 paly()");
	}
}
public class SuperMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);
		ch.play();
		
	}
}
