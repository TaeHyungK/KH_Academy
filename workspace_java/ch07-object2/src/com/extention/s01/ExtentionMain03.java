package com.extention.s01;

class A{
	int x = 100;
	private int y= 200;
	
	public int getY() {
		return y;
	}
}

class B extends A{
	int z = 300;
}

public class ExtentionMain03 {
	public static void main(String[] args) {
		B bp = new B();
		System.out.println(bp.x);
		//private ��������� ���� Ŭ���� �׿����� ȣ�� �����ϱ� ������
		//��� ���迡 �ִ� ��쿡�� �ٸ� Ŭ�������� ȣ�� �Ұ���
//		System.out.println(bp.y); 
		System.out.println(bp.z);
		
		System.out.println(bp.getY());
	}
}
