package com.instance.s01;

public class Student4 {
	String name;
	int age;
		
	public static void main(String[] args) {
		//객체 선언 및 생성
		Student4 s1 = new Student4();
		System.out.println("s1 참조값: "+s1);
		
		//멤버변수의 값 변경
		s1.name = "홍길동";
		s1.age = 30;
		
		System.out.println(s1.name+","+ s1.age);
		System.out.println("----------------");
		
		Student4 s2 = new Student4();
		System.out.println("s2 참조값: "+s2);
		s2.name = "박문수";
		s2.age = 40;
		System.out.println(s2.name+","+ s2.age);
		
	}
}
