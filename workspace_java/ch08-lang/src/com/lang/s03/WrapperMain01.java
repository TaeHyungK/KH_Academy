package com.lang.s03;

public class WrapperMain01 {
	public static void main(String[] args) {
		boolean b = true; // �⺻ �ڷ��� ������
		// �⺻�ڷ��� ������ -> �����ڷ��� ������
		Boolean wrap_b = new Boolean(b);
		// �����ڷ��� ������ -> �⺻�ڷ��� ������
		boolean b2 = wrap_b.booleanValue();
		System.out.println(b2);

		char c = 'A';
		// �⺻�ڷ��� ������ -> �����ڷ��� ������
		Character wrap_c = new Character(c);
		// �����ڷ��� ������ -> �⺻�ڷ��� ������
		System.out.println(wrap_c.charValue());
		
		// �⺻�ڷ��� ������ -> �����ڷ��� ������
		Integer wrap_i = new Integer(100);
		// �����ڷ��� ������ -> �⺻�ڷ��� ������
		System.out.println(wrap_i.intValue());

	}
}
