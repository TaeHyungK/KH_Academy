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
			System.out.println("예외 발생!!!");
		}
	}
	
	private void printData() throws IOException,NumberFormatException {
		//throws는 예외처리가 아니라 예외를 양도 또는 임시 보관한다는 표현
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("단입력: ");
		int dan = Integer.parseInt(buf.readLine());
		System.out.println(dan+"단");
		System.out.println("--------");
		for(int i=1;i<=9;i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
	}
}
