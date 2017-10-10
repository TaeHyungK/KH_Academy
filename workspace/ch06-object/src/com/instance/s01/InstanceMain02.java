package com.instance.s01;

public class InstanceMain02 {
	int var1;
	String var2;
	
	public static void main(String[] args) {
		//객체 선언
		//InstanceMain02 : 참조자료형
		//me : 참초변수
		InstanceMain02 me;
		
		//객체 생성
		//new : 객체 생성시 호출하는 연산자
		//InstanceMain02() : 생성자
		me = new InstanceMain02();
		
		System.out.println(me);
		System.out.println(me.var1);
		System.out.println(me.var2);
		
		me.var1=10;
		me.var2="서울";
		System.out.println(me.var1);
		System.out.println(me.var2);
		
	}
}
