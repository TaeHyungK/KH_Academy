package com.instance.s01;

public class Student {
	//��� �ʵ�
	String name;
	int age;
	
	public static void main(String[] args) {
		//��ü ���� �� ����
		Student student = new Student();
		
		//����ʵ� ���
		System.out.println(student.name);
		System.out.println(student.age);
		
		//����ʵ� �� ����
		
		student.name = "ȫ�浿";
		student.age = 20;
		System.out.println(student.name+","+student.age);
				
	}
}
