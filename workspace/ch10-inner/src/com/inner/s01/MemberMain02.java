package com.inner.s01;

class Outer2{
	private int x = 200;
	
	class Inner2{
		private int y=200;
		public void print() {
			//��� ����Ŭ������ �������Ŭ������ ���Ե� Ŭ������ ����ʵ带 ������ �� ����
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
