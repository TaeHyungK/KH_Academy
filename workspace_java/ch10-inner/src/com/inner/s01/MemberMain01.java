package com.inner.s01;

class Outer{
	//��� ����
	int x=100;
	//��� ���� Ŭ����
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
