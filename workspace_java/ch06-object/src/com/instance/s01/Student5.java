package com.instance.s01;

public class Student5 {
	String name;
	int age;
	
	public static void main(String[] args) {
		Student5 s1 = new Student5();
		System.out.println(s1);
		
		s1.name = "ȫ�浿";
		s1.age = 20;
		System.out.println(s1.name +"," + s1.age);
		
		//s1�� ��ü�� �ּҰ� ����Ǿ� �ְ�
		//����Ǿ� �ִ� �ּҸ� �� �ٸ� ����������
		//�Ҵ�
		Student5 s2 = s1;
		System.out.println(s2);
		s2.name = "�ڹ���";
		s2.age = 30;
		System.out.println(s1.name +"," + s1.age);
		System.out.println(s2.name +"," + s2.age);
		
	}
}
