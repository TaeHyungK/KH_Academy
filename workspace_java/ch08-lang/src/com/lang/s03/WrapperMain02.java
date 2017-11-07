package com.lang.s03;

public class WrapperMain02 {
	public static void main(String[] args) {
		//�⺻�ڷ��� ������ -> �����ڷ��� ������
		// boxing
		Integer obj1 = new Integer(12);
		Integer obj2 = new Integer(7);
		
		//�����ڷ��� ������ -> �⺻�ڷ��� ������ 
		//unboxing
		int result = obj1.intValue() + obj2.intValue();
		System.out.println("result = " + result);
		
		//JDK5.0�̻���� auto boxing/unboxing ��밡��
		
		//�⺻�ڷ��� ������ -> �����ڷ��� ������ : auto boxing
		Integer obj3 = 10;
		Integer obj4 = 20;
		
		//�����ڷ��� ������ -> �⺻�ڷ��� ������ : auto unboxing
		int result1 = obj3 + obj4;
		System.out.println(result1);
	}
}
