package com.instance.s04;

public class StaticMain02 {
	int a; // �ν��Ͻ� ����
	static String s; // static ����
	
	
	public static void main(String[] args) {
//		�ν��Ͻ� ������ ��ü ���� ���� ȣ�� �Ұ���
//		a = 100;
		
//		���� Ŭ������ ��õ� static������ ȣ��� Ŭ������ ���� ����
		StaticMain02.s = "��";
		s = "����";
		
		System.out.println("s: " + s);
		
		StaticMain02 st1 = new StaticMain02();
		st1.a = 1000;
		System.out.println("st1.a: " + st1.a);
	}
}
