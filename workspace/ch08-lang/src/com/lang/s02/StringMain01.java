package com.lang.s02;

public class StringMain01 {
	public static void main(String[] args) {
		//�Ͻ��� String ����
		String str1 = "abc";
		String str2 = "abc";
//		System.out.println(str1.toString()); 
//		//String�� toString()�� �����ǵ�
//		System.out.println(str2);
		
		//��ü ��
		if(str1 == str2) {
			System.out.println("str1�� str2�� ���� ��ü");
		}else {
			System.out.println("str1�� str2�� �ٸ� ��ü");
		}
		
		//���ڿ� �� -> String�� equals�޼ҵ�� ������ �Ǿ���.
		if(str1.equals(str2)) {
			System.out.println("str1�� str2�� ���� ���ڿ�");
		}else {
			System.out.println("str1�� str2�� �ٸ� ���ڿ�");
		}
		System.out.println("-------------");
		
		//����� String ����
		String str3= new String("Hello");
		String str4= new String("Hello");
		
		//��ü ��
		if(str3 == str4) {
			System.out.println("str3�� str4�� ���� ��ü");
		}else {
			System.out.println("str3�� str4�� �ٸ� ��ü");
		}
		
		//���ڿ� �� -> String�� equals�޼ҵ�� ������ �Ǿ���.
		if(str3.equals(str4)) {
			System.out.println("str3�� str4�� ���� ���ڿ�");
		}else {
			System.out.println("str3�� str4�� �ٸ� ���ڿ�");
		}
		
		
	}
}
