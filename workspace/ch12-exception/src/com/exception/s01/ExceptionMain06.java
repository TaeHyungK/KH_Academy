package com.exception.s01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain06 {
	public static void main(String[] args) {
		ExceptionMain06 em = new ExceptionMain06();
		try {
			em.printData();
		} catch (IOException | NumberFormatException e) {
			System.out.println("���� �߻�!!!");
		}
	}
	
	private void printData() throws IOException,NumberFormatException {
		//throws�� ����ó���� �ƴ϶� ���ܸ� �絵 �Ǵ� �ӽ� �����Ѵٴ� ǥ��
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���Է�: ");
		int dan = Integer.parseInt(buf.readLine());
		System.out.println(dan+"��");
		System.out.println("--------");
		for(int i=1;i<=9;i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
	}
}
