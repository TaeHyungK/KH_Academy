package com.instance.s03;

public class OverloadingMain02 {
	//�޼ҵ� �����ε�(�ߺ�����)
	public void getLength(int a) {
		//int -> String
		String s = String.valueOf(a);
		//������ Ÿ���� String�� �޼ҵ带 ȣ��
		getLength(s);
	}
	public void getLength(float f) {
		//float -> String
		String s = String.valueOf(f);
		//������ Ÿ���� String�� �޼ҵ带 ȣ��
		getLength(s);
	}
	public void getLength(String str) {
		//String -> String
		System.out.println("�Է��� ���� ����: " + str.length());
	}
	
	
	
	public static void main(String[] args) {
		OverloadingMain02 ot = new OverloadingMain02();
		
		ot.getLength(10000);
		ot.getLength(3.14f);
		ot.getLength("Hello!");
	}
}