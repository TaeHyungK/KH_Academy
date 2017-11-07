package com.instance.s01;

public class Student5 {
	String name;
	int age;
	
	public static void main(String[] args) {
		Student5 s1 = new Student5();
		System.out.println(s1);
		
		s1.name = "홍길동";
		s1.age = 20;
		System.out.println(s1.name +"," + s1.age);
		
		//s1에 객체의 주소가 저장되어 있고
		//저장되어 있는 주소를 또 다른 참조변수에
		//할당
		Student5 s2 = s1;
		System.out.println(s2);
		s2.name = "박문수";
		s2.age = 30;
		System.out.println(s1.name +"," + s1.age);
		System.out.println(s2.name +"," + s2.age);
		
	}
}
