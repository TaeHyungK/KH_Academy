package com.iostream.s02;

import java.io.IOException;

public class StandardInput01 {
	public static void main(String[] args) {
		//�ڹ� ǥ�� �Է�
		System.out.print("������ 1�� �Է�> ");
		try {
			//1����Ʈ �Է�ó��.
			//���� �ϳ��� �Է¹޾Ƽ� �ƽ�Ű �ڵ�� ��ȯ
			int a = System.in.read(); //ASCII�ڵ� ���� ����
			System.out.println(a + ", " + (char)a);
			
			//Enter(\r\n)�� ���������� ��
			System.in.read(); // \r���
			System.in.read(); // \n���
			
			System.out.print("����1�� �Է�> ");
			int b = System.in.read()-48;
			System.out.println(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
