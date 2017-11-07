package com.lang.s03;

public class WrapperMain01 {
	public static void main(String[] args) {
		boolean b = true; // 기본 자료형 데이터
		// 기본자료형 데이터 -> 참조자료형 데이터
		Boolean wrap_b = new Boolean(b);
		// 참조자료형 데이터 -> 기본자료형 데이터
		boolean b2 = wrap_b.booleanValue();
		System.out.println(b2);

		char c = 'A';
		// 기본자료형 데이터 -> 참조자료형 데이터
		Character wrap_c = new Character(c);
		// 참조자료형 데이터 -> 기본자료형 데이터
		System.out.println(wrap_c.charValue());
		
		// 기본자료형 데이터 -> 참조자료형 데이터
		Integer wrap_i = new Integer(100);
		// 참조자료형 데이터 -> 기본자료형 데이터
		System.out.println(wrap_i.intValue());

	}
}
