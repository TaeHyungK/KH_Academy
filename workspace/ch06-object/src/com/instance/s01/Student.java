package com.instance.s01;

public class Student {
	//멤버 필드
	String name;
	int age;
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		Student student = new Student();
		
		//멤버필드 출력
		System.out.println(student.name);
		System.out.println(student.age);
		
		//멤버필드 값 변경
		
		student.name = "홍길동";
		student.age = 20;
		System.out.println(student.name+","+student.age);
				
	}
}
