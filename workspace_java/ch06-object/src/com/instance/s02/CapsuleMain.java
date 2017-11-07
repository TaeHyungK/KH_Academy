package com.instance.s02;

class Capsule{
	//은닉화
	//같은 클래스내에서만 호출 가능
	private int a;
	
	//캡슐화
	public void setA(int n) {
		if(n>=0)
			a = n;
		else
			System.out.println("음수는 허용되지 않습니다.");
	}
	
	public int getA() {
		return a;
	}
	
}

public class CapsuleMain {
	public static void main(String[] args) {
		Capsule cap = new Capsule();
		//변수 a의 접근 지정자가 private이기 때문에 같은 클래스 내에서는 호출이 가능하지만
		//다른 클래스에서 호출 불가능
//		cap.a = -1;
//		System.out.println(cap.a);
		
		cap.setA(100);
		System.out.println(cap.getA());
		System.out.println("------------------");
		
		cap.setA(-200);
		System.out.println(cap.getA());
		
		
	}
}
