package com.extention.s12;

interface A1 {
	public static final int W = 10; // ����
	int X = 20;
	static int Y = 30;
	final int Z = 40;
}

public class InterMain01 {
	public static void main(String[] args) {

		// �������̽��� ��ü ���� �Ұ���
		// A1 ap = new A1();
		//����� �� ���� �Ұ���
		// A1.W = 100;

		System.out.println("W = " + A1.W);
		System.out.println("X = " + A1.X);
		System.out.println("Y = " + A1.Y);
		System.out.println("Z = " + A1.Z);
		
	}

}
