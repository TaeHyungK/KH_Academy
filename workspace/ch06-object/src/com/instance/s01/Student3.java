package com.instance.s01;

public class Student3 {
	//��� �ʵ�
	String name;
	int kor;
	int math;
	int eng;
	
	public int getSum() {
		return kor+math+eng;
	}
	
	public double getAvg() {
		return getSum()/3.0;
	}
	
	public static void main(String[] args) {
		//��ü ���� �� ����
		Student3 student = new Student3();
		student.name="ȫ�浿";
		student.kor=98;
		student.math=97;
		student.eng=95;
		
		//���
		System.out.println("�̸�: " + student.name);		
		System.out.println("����: " + student.kor);		
		System.out.println("����: " + student.math);		
		System.out.println("����: " + student.eng);		
		System.out.println("����: " + student.getSum());
		System.out.printf("���: %.2f", student.getAvg());
	}
}
