package com.instance.s02;


public class MethodMain02 {
	
	//메소드의 인자에 값을 복사해서 전달
	public int increase(int n) {
		++n;
		return n;
	}
	public static void main(String[] args) {
		System.out.println("메소드 이자 전달 방식");
		//값에 의한 호출
		//기본 자료형의 값을 인자로 전달하는 방식
		int var1 = 100;
		
		MethodMain02 mt = new MethodMain02();
					//기본 자료형의 값이 복사
		int var2 = mt.increase(var1);
		
		System.out.println("var1: "+var1);
		System.out.println("var2: "+var2);
	}
}
