package com.instance.s04;

public class StaticMain02 {
	int a; // 인스턴스 변수
	static String s; // static 변수
	
	
	public static void main(String[] args) {
//		인스턴스 변수는 객체 생성 없이 호출 불가능
//		a = 100;
		
//		같은 클래스에 명시된 static변수는 호출시 클래스명 생략 가능
		StaticMain02.s = "봄";
		s = "가을";
		
		System.out.println("s: " + s);
		
		StaticMain02 st1 = new StaticMain02();
		st1.a = 1000;
		System.out.println("st1.a: " + st1.a);
	}
}
