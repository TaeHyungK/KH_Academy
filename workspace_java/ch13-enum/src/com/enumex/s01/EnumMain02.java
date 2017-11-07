package com.enumex.s01;

//JDK5.0이상부터 사용 가능
//열거형 상수를 가지고 생성되는 객체
enum Lesson{
	JAVA,XML,JSP
}

public class EnumMain02 {
	public static void main(String[] args) {
		System.out.println(Lesson.JAVA);
		System.out.println(Lesson.XML);
		System.out.println(Lesson.JSP);
		System.out.println("--------");
		
		//열거 객체의 문자열 반환
		System.out.println(Lesson.JAVA.name());
		System.out.println(Lesson.XML.name());
		System.out.println(Lesson.JSP.name());
		System.out.println("--------");
		
		//열거 객체의 순번(0부터 시작)을 반환
		System.out.println(Lesson.JAVA.ordinal());
		System.out.println(Lesson.XML.ordinal());
		System.out.println(Lesson.JSP.ordinal());
	}
}
