package com.exception.s01;

public class ExceptionMain03 {
	public static void main(String[] args) {
		int var = 50;
		try {
			int data = Integer.parseInt(args[0]);
			
			System.out.println(var/data);
			/*
			 * 다중 catch문을 사용할 때는 상위예외 클래스는 아래 명시하고
			 * 하위예외 클래스는 상위예외클래스보다 위에 명시해야함.
			 */
		}catch(NumberFormatException e) {
			System.out.println("숫자가 아닙니다.");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("입력한 데이터가 없습니다.");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌순 없죠!!");
		}catch(Exception e) {
			System.out.println("나머지 예외는 내가~~");
		}
		
		System.out.println("프로그램 종료!");
	}
}
