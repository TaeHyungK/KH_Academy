package com.lang.s02;

public class StringMain02 {
	public static void main(String[] args) {
		String str1 = "bus";
		String str2 = "BUS";
		
		//��ҹ��� ���� ���ڿ� ��
		if(str1.equals(str2)) {
			System.out.println("str1�� str2�� ���� ���ڿ�");
		}else {
			System.out.println("str1�� str2�� �ٸ� ���ڿ�");
		}
		
		//��ҹ��� �������� ���ڿ� ��
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("str1�� str2�� ���� ���ڿ�");
		}else {
			System.out.println("str1�� str2�� �ٸ� ���ڿ�");
		}
		
		
	}
}
