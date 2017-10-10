package com.inner.s01;

class Outer{
	//멤버 변수
	int x=100;
	//멤버 내부 클래스
	class Inner{
		int y= 200;
	}
}

public class MemberMain01 {
	public static void main(String[] args) {
		Outer ot = new Outer();
		Outer.Inner oi = ot.new Inner();
		
		System.out.println("x = " + ot.x);
		System.out.println("y = " + oi.y);
		
	}
}
