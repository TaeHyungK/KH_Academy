package com.iostream.s02;

import java.io.IOException;

public class StandardInput01 {
	public static void main(String[] args) {
		//자바 표준 입력
		System.out.print("영문자 1개 입력> ");
		try {
			//1바이트 입력처리.
			//문자 하나만 입력받아서 아스키 코드로 반환
			int a = System.in.read(); //ASCII코드 값을 읽음
			System.out.println(a + ", " + (char)a);
			
			//Enter(\r\n)을 흡수시켜줘야 함
			System.in.read(); // \r흡수
			System.in.read(); // \n흡수
			
			System.out.print("숫자1개 입력> ");
			int b = System.in.read()-48;
			System.out.println(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
