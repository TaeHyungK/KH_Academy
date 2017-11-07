package com.extention.s12;

interface Inter1{
	public int getA();
}
interface Inter2{
	public int getB();
}

//인터페이스 Inter3에 인터페이스 Inter1과 Inter2를 상속
//다중상속 가능이유? -> 인터페이스는 형식만 가지고 있기 때문에
interface Inter3 extends Inter1, Inter2{
	public int getData();
}

public class InterMain04 implements Inter3 {
	public static void main(String[] args) {
		InterMain04 im = new InterMain04();
		System.out.println(im.getA());
		System.out.println(im.getB());
		System.out.println(im.getData());
	}

	@Override
	public int getA() {
		return 10;
	}

	@Override
	public int getB() {
		return 20;
	}

	@Override
	public int getData() {
		return 30;
	}
}
