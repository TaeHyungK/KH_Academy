package com.exception.s01;

public class ExceptionMain03 {
	public static void main(String[] args) {
		int var = 50;
		try {
			int data = Integer.parseInt(args[0]);
			
			System.out.println(var/data);
			/*
			 * ���� catch���� ����� ���� �������� Ŭ������ �Ʒ� ����ϰ�
			 * �������� Ŭ������ ��������Ŭ�������� ���� ����ؾ���.
			 */
		}catch(NumberFormatException e) {
			System.out.println("���ڰ� �ƴմϴ�.");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�Է��� �����Ͱ� �����ϴ�.");
		}catch(ArithmeticException e) {
			System.out.println("0���� ������ ����!!");
		}catch(Exception e) {
			System.out.println("������ ���ܴ� ����~~");
		}
		
		System.out.println("���α׷� ����!");
	}
}
