package com.lang.s02;

public class StringMain03 {
	public static void main(String[] args) {
		String s1 = "Kwon Sun Ae";
//					 012345678910 -> 11
		int index = s1.indexOf('n');
		System.out.println("�� ó�� ���� n�� ��ġ: " + index);
		
		index = s1.indexOf("Sun");
		System.out.println("���ڿ� Sun�� ��ġ: " + index);
		
		index = s1.lastIndexOf('n');
		System.out.println("������ ���� n�� ��ġ: " + index);
		
		char c = s1.charAt(index); // ���� ����
		System.out.println("������ ����: " + c);
		
		index = s1.indexOf('S');
		String str = s1.substring(index); //�κ� ���ڿ� ����
		System.out.println("�빮�� S���� ������ ���ڿ�: " + str);
		
		//substring(�����ε���,���ε���): �����ε��� ~ (���ε���-1)���� ���
		str = s1.substring(index, (index+3));
		System.out.println("�빮�� S���� 3ĭ ���ڿ�: " + str);
		
		int length = s1.length();
		System.out.println("s1�� ����: " + length);
		
		String[] array = s1.split(" ");
		for(int i=0;i<array.length;i++) {
			System.out.println("array["+i+"]: "+array[i]);
		}
	}
}
