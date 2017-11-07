package com.extention.s11;

//추상클래스는 객체 생성 불가능
abstract class A{
	int x = 10;
	int y;
	
	public void setY(int y) {
		this.y = y;
	}
	
	//추상메소드: 미구현된 메소드
	abstract public void abc();
}

class B extends A{

	//추상메소드 구현
	//부모클래스에 추상메소드가 포함되어있으면 반드시 자식클래스에서
	//추상메소드를 일반메소드로 구현해야 함
	@Override
	public void abc() {
		System.out.println("abc 메소드");
	}

}
public class AbstractMain01 {
	public static void main(String[] args) {
//		A ap = new A();
		B bp = new B();
		
		bp.abc();
	}
}
