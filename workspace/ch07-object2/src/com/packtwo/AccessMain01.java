package com.packtwo;

import com.packone.People;

public class AccessMain01 {
	public static void main(String[] args) {
		People p = new People();
//		System.out.println(p.a); -> a�� ���������ڰ� private����
//		System.out.println(p.b); -> b�� ���������ڰ� default, default������ ���� ��Ű�� �������� ȣ�� ����
//		System.out.println(p.c); -> c�� ���������ڰ� protected, protected������ ���� ��Ű���϶� ��Ӱ����� �� ȣ�� ����
		System.out.println(p.d); //-> d�����������ڰ� public, ��� ������ ���� ����
	}
}
