package com.exception.s01;

public class ExceptionMain01 {
	public static void main(String[] args) {
		int[] array = {100,200,300};
		
		//�ε��� 3�� ���µ� �ε��� 3�� ȣ���ؼ� ���� �߻�
		for(int i=0;i<=array.length;i++) {
			System.out.println("array["+i+"]: "+array[i]);
		}
		
		System.out.println("���α׷� ��");
	}
}
