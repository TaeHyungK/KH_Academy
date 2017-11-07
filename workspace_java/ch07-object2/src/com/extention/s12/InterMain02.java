package com.extention.s12;

//인터페이스 : 형식만 있고 내용이 없음
interface A2{
	public abstract void getA(); //원형
	void getB(); // 인터페이스는 public abstract 생략되어 있음
}

//일반클래스에 인터페이스를 구현
class B2 implements A2{
	//인터페이스의 추상메소드 구현
	@Override
	public void getA() {
		System.out.println("getA 메소드");
	}

	@Override
	public void getB() {
		System.out.println("getB 메소드");
	}
	
}

public class InterMain02 {
	public static void main(String[] args) {
		
	}
}
