package com.lang.s03;

public class WrapperMain02 {
	public static void main(String[] args) {
		//기본자료형 데이터 -> 참조자료형 데이터
		// boxing
		Integer obj1 = new Integer(12);
		Integer obj2 = new Integer(7);
		
		//참조자료형 데이터 -> 기본자료형 데이터 
		//unboxing
		int result = obj1.intValue() + obj2.intValue();
		System.out.println("result = " + result);
		
		//JDK5.0이상부터 auto boxing/unboxing 사용가능
		
		//기본자료형 데이터 -> 참조자료형 데이터 : auto boxing
		Integer obj3 = 10;
		Integer obj4 = 20;
		
		//참조자료형 데이터 -> 기본자료형 데이터 : auto unboxing
		int result1 = obj3 + obj4;
		System.out.println(result1);
	}
}
