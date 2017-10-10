package com.extention.s10;

class A{
	//상수
	final int NUM = 10;
	//상수를 초기화하지 않으면 생성자를 통해 초기화를 해줘야함
	final int TES;
	//static 상수
	public static final int NUMBER = 20;
	
	
	public A(int tes){
		TES = tes;
	}
	
}

public class FinalMain01 {
	public static void main(String[] args) {
		
		//지역 상수 : 메인 안에서만 호출 가능, 접근지정자 사용 불가능
		final int NO = 30;
		System.out.println(NO);
		
		//static 상수 호출
		System.out.println(A.NUMBER);
		
		A ap = new A(30);
		//상수는 변경 불가능
//		ap.NUM = 100;
//		ap.TES = 200;
		
		System.out.println(ap.NUM);
		System.out.println(ap.TES);
		
	}
}
