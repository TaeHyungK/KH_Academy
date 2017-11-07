package com.instance.s05;

class ThisTest {
	// 은닉화
	private int a;

	// 캡슐화
	
	//지역변수명과 멤버변수명이 동일하면 블럭내에서 지역변수가 우선 적용
	public int getA() {
		return a;
	}

	public void setA(int a) {
	//this는 객체 내부에서 객체를 참조하는 참조변수의 역할을 하기 땜누에 지역변수명과
	//멤버변수명이 같을 때 멤버변수명을 지칭하고자 사용할 수 있음
	   //멤버변수  지역변수
		this.a = a;
	}
}

public class ThisMain02 {
	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		tt.setA(10);
		System.out.println(tt.getA());
	}
}
