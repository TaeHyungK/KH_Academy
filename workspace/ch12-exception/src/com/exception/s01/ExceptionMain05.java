package com.exception.s01;

public class ExceptionMain05 {
	public static void main(String[] args) {
		System.out.println("���ܰ� �߻����� �ʾ��� ���");
		try {
			System.out.println("1");
			System.out.println("2");
		}catch(Exception e){
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
		System.out.println("���α׷� ����");
		System.out.println("------------------");
		
		try {
			System.out.println("1");
			System.out.println(10/0); //���� �߻�
			System.out.println("2"); //�̽���
		}catch(Exception e) {
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
		System.out.println("���α׷� ����");
		System.out.println("------------------");
		
	}
}
