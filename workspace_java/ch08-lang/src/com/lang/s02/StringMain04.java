package com.lang.s02;

public class StringMain04 {
	public static void main(String[] args) {
		String s1 = "   aBa   ";
		String s2 = "abc";
		int a = 100;
		String msg = null;
		
		//�빮�ڷ� ��ü
		msg = s1.toUpperCase();
		System.out.println(msg);
		//�ҹ��ڷ� ��ü
		msg = s1.toLowerCase();
		System.out.println(msg);
		
		//Ư�� ���ڿ��� �ٸ� ���ڿ��� ��ü
		msg = s1.replace("aB", "b");
		System.out.println(msg);
		
		//���� ���� -> �߰� ������ ���� �Ұ���
		msg = s1.trim();
		System.out.println(msg);
		
		//���ڿ����� Ư�� ���ڿ��� ���ԵǾ� �ִ��� ���� üũ
		boolean f = s1.contains("aB");
		System.out.println(f);
		
		//���ڿ����� Ư�� ���ڿ��� �� �տ� �ִ��� ���� üũ
		f = s2.startsWith("ab");
		System.out.println(f);
		
		//���ڿ����� Ư�� ���ڿ��� �� �ڿ� �ִ��� ���� üũ
		f = s2.endsWith("cz");
		System.out.println(f);
		
//		int -> String
		msg = String.valueOf(a);
		msg = ""+a;
	}
}
