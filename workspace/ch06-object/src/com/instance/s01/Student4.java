package com.instance.s01;

public class Student4 {
	String name;
	int age;
		
	public static void main(String[] args) {
		//��ü ���� �� ����
		Student4 s1 = new Student4();
		System.out.println("s1 ������: "+s1);
		
		//��������� �� ����
		s1.name = "ȫ�浿";
		s1.age = 30;
		
		System.out.println(s1.name+","+ s1.age);
		System.out.println("----------------");
		
		Student4 s2 = new Student4();
		System.out.println("s2 ������: "+s2);
		s2.name = "�ڹ���";
		s2.age = 40;
		System.out.println(s2.name+","+ s2.age);
		
	}
}
