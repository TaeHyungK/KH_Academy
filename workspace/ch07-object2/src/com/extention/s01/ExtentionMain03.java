package com.extention.s01;

class A{
	int x = 100;
	private int y= 200;
	
	public int getY() {
		return y;
	}
}

class B extends A{
	int z = 300;
}

public class ExtentionMain03 {
	public static void main(String[] args) {
		B bp = new B();
		System.out.println(bp.x);
		//private 멤버변수는 같은 클래스 네에서만 호출 가능하기 때문에
		//상속 관계에 있는 경우에도 다른 클래스에서 호출 불가능
//		System.out.println(bp.y); 
		System.out.println(bp.z);
		
		System.out.println(bp.getY());
	}
}
