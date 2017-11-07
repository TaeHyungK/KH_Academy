package com.extention.s03;

class People2{
	int a=10;
	public People2() {
		super(); //Object의 생성자
	}
}

class Student extends People2{
	int b=20;
	public Student() {
		super(); //부모클래스 People2의 생성자
	}
}

public class SuperMain02 {
	public static void main(String[] args) {
		Student st = new Student();
		System.out.println(st.a);
		System.out.println(st.b);
	}
}
