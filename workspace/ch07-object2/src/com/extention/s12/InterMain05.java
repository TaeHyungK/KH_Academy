package com.extention.s12;

interface InterA{
	public void make();
}

class InterEx2 implements InterA{
	
	@Override
	public void make() {
		System.out.println("make 메소드");
	}
	
	public void fun() {
		System.out.println("fun 메소드");
	}
}


public class InterMain05 implements InterA{
	public static void main(String[] args) {
		InterEx2 ie = new InterEx2();
		
		ie.make();
		ie.fun();
		
		//클래스타입 -> 인터페이스타입 형변환
		//자동적으로 형변환
		InterA a = ie;
		a.make();
		//호출 범위를 벗어나 호출 불가
		//a.fun();
		
		//인터페이스타입 -> 클래스타입 형변환
		//명시적으로 형벼환
		InterEx2 ie2 = (InterEx2) a;
		ie2.make();
		ie2.fun();
	}
	
	

	@Override
	public void make() {
		System.out.println("make 메소드");
	}
	public void fun() {
		System.out.println("fun 메소드");
	}
}
