package com.extention.s03;

class People2{
	int a=10;
	public People2() {
		super(); //Object�� ������
	}
}

class Student extends People2{
	int b=20;
	public Student() {
		super(); //�θ�Ŭ���� People2�� ������
	}
}

public class SuperMain02 {
	public static void main(String[] args) {
		Student st = new Student();
		System.out.println(st.a);
		System.out.println(st.b);
	}
}
