package com.instance.s01;

public class Student2 {
	//��� �ʵ�
	String name;
	int kor;
	int math;
	int eng;
	int sum;
	double avg;
	
	public static void main(String[] args) {
		//��ü ���� �� ����
		Student2 student = new Student2();
		
		student.name = "ȫ�浿";
		student.kor= 98;
		student.math= 97;
		student.eng= 95;
		student.sum= student.kor + student.math + student.eng;
		student.avg= student.sum/3.0;
		
		System.out.println("�̸�: " + student.name);		
		System.out.println("����: " + student.kor);		
		System.out.println("����: " + student.math);		
		System.out.println("����: " + student.eng);		
		System.out.println("����: " + student.sum);
		System.out.printf("���: %.2f", student.avg);
	}
	
}
