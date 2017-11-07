package com.extention.s01;
//부모클래스
class People{
	public void eat() {
		System.out.println("식사하다");
	}
}
//자식클래스
class Student extends People{
	public void study() {
		System.out.println("공부하다");
	}
}

public class ExtentionMain02 {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.eat();//People에서 상속받은 메소드
		s1.study();//Student의 메소드
		System.out.println(s1.toString());//Object에서 상속받은 메소드
		
	}
}
