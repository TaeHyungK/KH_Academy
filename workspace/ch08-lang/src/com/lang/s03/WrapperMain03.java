package com.lang.s03;

public class WrapperMain03 {
	public static void main(String[] args) {
//		int�� 0���� ���� �� ����
//		int a = 5;
//		int b= 0;
//		System.out.println(a/b);
		
		double x = 5.0;
		double y = 0.0;
		
		double z = x/y;
		System.out.println(z);
		
		//isFinite() : ������ ���� ���� �� ������ true ��ȯ
		if(Double.isFinite(z)) {
			System.out.println("��: " + z);
		}else {
			System.out.println("0���� ���� �� �����ϴ�.");
		}
	}
}
