package com.packtwo;

import com.packone.People;

class Student extends People{
	public void print() {
//		System.out.println("a: " + a);//a�� private, ���� Ŭ������ �ƴϿ��� �� �ҷ���
//		System.out.println("b: " + b);//b�� default, ���� ��Ű���� �ƴϿ��� �� �ҷ���
		System.out.println("c: " + c);//c�� protected, �ٸ� ��Ű������ ��� ����� �ҷ��� �� ����
		System.out.println("d: " + d);//d�� public
	}
}

public class AccessMain02 {
	public static void main(String[] args) {
		Student s = new Student();
//		System.out.println(s.a);//private, ���� Ŭ������ �ƴ�
//		System.out.println(s.b);//default, ���� ��Ű���� �ƴ�
//		System.out.println(s.c);//protected, ���� ��Ű���� �ƴϰ� ��Ӱ��赵 �ƴ�(AccessMain02�� People�� ) 
		System.out.println(s.d);//public, 
	}
}
