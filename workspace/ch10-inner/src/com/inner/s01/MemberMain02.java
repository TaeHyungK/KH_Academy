package com.inner.s01;

class Outer2{
	private int x = 200;
	
	class Inner2{
		private int y=200;
		public void print() {
			//멤버 내부클래스는 멤버내부클래스가 포함된 클래스의 멤버필드를 참조할 수 있음
			System.out.println("x = " + x);
			System.out.println("y = " + y);
		}
	}
}

public class MemberMain02 {
	public static void main(String[] args) {
		Outer2 ot = new Outer2();
		Outer2.Inner2 oi = ot.new Inner2();
		
		oi.print();
	}
}
