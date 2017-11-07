package com.inner.s01;

public class InnerMain01 {
	
	//static 내부 클래스
	//static 내부 클래스를 포함한 클래스의 객체 생성없이
	// static 내부 클래스 객체를 생성
	//static 내부클래스만 static 변수, 메소드를 정의할 수 있음
	public static class StaticInner{
		int iv = 200;
		static int cv = 300;
		static void make() {
			System.out.println("하하");
		}
	}
	
	public static void main(String[] args) {
		InnerMain01.StaticInner i = new InnerMain01.StaticInner();
		System.out.println(i.iv);
		
		//static 변수 호출
		System.out.println(InnerMain01.StaticInner.cv);
		
		//static 메소드 호출
		InnerMain01.StaticInner.make();
	}
}
