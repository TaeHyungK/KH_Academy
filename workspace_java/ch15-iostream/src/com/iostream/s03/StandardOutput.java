package com.iostream.s03;

public class StandardOutput {
	public static void main(String[] args) {
		//ǥ�� ���
		System.out.println("Hello Wolrd!");
		
		//ǥ�� ���� ���
		try {
			System.out.println(5/0);
		}catch(Exception e) {
			//���� �۾��� ǥ��
			System.err.println("0���� ���� �� �����ϴ�.");
			
		}
	}
}
