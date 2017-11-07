package com.instance.s05;

public class ThisMain01 {
	
	//this: 객체 내부에서 객체를 참조하는 참조 변수와 같은 역할
	public ThisMain01() {
		System.out.println("객체 생성: " + this);
	}
	
	public static void main(String[] args) {
		ThisMain01 tm = new ThisMain01();
		System.out.println("객체 생성 후: " + tm);
		
	}
}
