package com.lang.s02;

public class StringBufferMain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("���� ����!!");
		
		System.out.println("1: " + sb);
		
		//������ �ε����� ���� ����
		sb.insert(2, '��');
		System.out.println("2: " + sb);
		
		//���� ���ڿ� �ڿ� ���ڿ� �߰�
		sb.append("������ ");
		System.out.println("3: " + sb);
		
		sb.append("�ÿ��ϴ�");
		System.out.println("4: " + sb);
		
		//�ε����� ����ؼ� �ε��� �������� ���ڿ��� ���ο� ���ڿ��� ��ü
		//start ~ (end-1) �ε�������  
		sb.replace(0, 3, "���డ��!!");
		System.out.println("5: " + sb);
		
		//�ε����� �����ؼ� �ش� ���ڸ� ����
		sb.deleteCharAt(0);
		System.out.println("6: " + sb);
		
		//�ε����� �����ؼ� �ش� ���ڿ��� ����
		//start ~ (end-1)�ε��� ����
		sb.delete(0, 3);
		System.out.println("7: " + sb);
		
		String str = sb.toString();
		System.out.println("str: " + str);
	}
}
