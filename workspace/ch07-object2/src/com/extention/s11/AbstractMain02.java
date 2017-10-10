package com.extention.s11;
//추상클래스
abstract class AbsEx1{
	int a = 100;
	public int getA() {
		return a;
	}
	//추상메소드
	abstract public String getStr();
	public abstract int getB();
}

abstract class AbsEx2 extends AbsEx1{
	String msg = "신세계";
	@Override
	public String getStr() {
		return msg;
	}
	//추상메소드
	abstract public int getC();
}



public class AbstractMain02 extends AbsEx2{
	public static void main(String[] args) {
		AbstractMain02 ab = new AbstractMain02();
		System.out.println(ab.getA());
		System.out.println(ab.getStr());
		System.out.println(ab.getB());
		System.out.println(ab.getC());
		
	}

	//부모클래스의 추상메소드를 반드시 구현
	@Override
	public int getC() {
		return 20;
	}

	@Override
	public int getB() {
		return 30;
	}
}
