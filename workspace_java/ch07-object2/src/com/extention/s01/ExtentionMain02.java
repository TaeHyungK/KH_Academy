package com.extention.s01;
//�θ�Ŭ����
class People{
	public void eat() {
		System.out.println("�Ļ��ϴ�");
	}
}
//�ڽ�Ŭ����
class Student extends People{
	public void study() {
		System.out.println("�����ϴ�");
	}
}

public class ExtentionMain02 {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.eat();//People���� ��ӹ��� �޼ҵ�
		s1.study();//Student�� �޼ҵ�
		System.out.println(s1.toString());//Object���� ��ӹ��� �޼ҵ�
		
	}
}
