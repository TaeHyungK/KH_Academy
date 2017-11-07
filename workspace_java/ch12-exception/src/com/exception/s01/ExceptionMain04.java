package com.exception.s01;

public class ExceptionMain04 {
	public static void main(String[] args) {
		try {
			int value1 = Integer.parseInt(args[0]);
			int value2 = Integer.parseInt(args[1]);
			
			int result = value1 + value2;
			System.out.println(value1+"+"+value2+"="+result);			
			
			//��Ƽ catch: ���ܸ� | �� ����
			//JDK7.0 �̻���� �ϳ��� catch��Ͽ��� �������� ���ܸ� ó���� �� ����.
		}catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("���� �Ű����� ���� �����ϰų� ���ڸ� ��ȯ�� �� �����ϴ�.");
		}catch(Exception e) {
			System.out.println("�� �� ���� ���� �߻�");
		}
	}
}
