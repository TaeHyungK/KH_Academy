package com.instance.s02;


public class MethodMain02 {
	
	//�޼ҵ��� ���ڿ� ���� �����ؼ� ����
	public int increase(int n) {
		++n;
		return n;
	}
	public static void main(String[] args) {
		System.out.println("�޼ҵ� ���� ���� ���");
		//���� ���� ȣ��
		//�⺻ �ڷ����� ���� ���ڷ� �����ϴ� ���
		int var1 = 100;
		
		MethodMain02 mt = new MethodMain02();
					//�⺻ �ڷ����� ���� ����
		int var2 = mt.increase(var1);
		
		System.out.println("var1: "+var1);
		System.out.println("var2: "+var2);
	}
}
