package com.extention.s10;

class A{
	//���
	final int NUM = 10;
	//����� �ʱ�ȭ���� ������ �����ڸ� ���� �ʱ�ȭ�� �������
	final int TES;
	//static ���
	public static final int NUMBER = 20;
	
	
	public A(int tes){
		TES = tes;
	}
	
}

public class FinalMain01 {
	public static void main(String[] args) {
		
		//���� ��� : ���� �ȿ����� ȣ�� ����, ���������� ��� �Ұ���
		final int NO = 30;
		System.out.println(NO);
		
		//static ��� ȣ��
		System.out.println(A.NUMBER);
		
		A ap = new A(30);
		//����� ���� �Ұ���
//		ap.NUM = 100;
//		ap.TES = 200;
		
		System.out.println(ap.NUM);
		System.out.println(ap.TES);
		
	}
}
