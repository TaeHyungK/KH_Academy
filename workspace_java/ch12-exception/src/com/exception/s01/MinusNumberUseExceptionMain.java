package com.exception.s01;

import java.util.Scanner;

//����� ���� ���� Ŭ����
//Exception�� ��ӹ޾Ƽ� ����Ŭ���� ����
class MinusNumberUseException extends Exception{
	public MinusNumberUseException(String str) {
		super(str);
	}
}

public class MinusNumberUseExceptionMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("0�̻� �Է�: ");
		try {
			int a= input.nextInt();
			if(a>=0) {
				System.out.println("�Է��� ����: " + a);
			}else {
				//����ڰ� ������ ���ܸ� ���������� �߻���Ŵ
				throw new MinusNumberUseException("������ �ԷµǾ����ϴ�.");
			}
		}catch(MinusNumberUseException e){
			System.out.println(e.getMessage());
		}finally {
			//�ڿ� ����
		}
		
	}
}
