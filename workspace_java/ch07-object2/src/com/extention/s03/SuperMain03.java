package com.extention.s03;

class Parent2{
	int a;
	public Parent2(int a) {
		this.a = a;
	}
}
class Child2 extends Parent2{
	
	public Child2() {
		//부모클래스에 디폴트 생성자가 없고 인자가 명시된 생성자만 존재할 경우
		//명시적으로 super(파라미터)를 이용해서 생성자를 호출하고 데이터를 전송해야 함.
		super(100);
	}
	
}

public class SuperMain03 {
	public static void main(String[] args) {
		
	}
}
