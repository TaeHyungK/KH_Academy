package com.exception.s01;

public class ExceptionMain04 {
	public static void main(String[] args) {
		try {
			int value1 = Integer.parseInt(args[0]);
			int value2 = Integer.parseInt(args[1]);
			
			int result = value1 + value2;
			System.out.println(value1+"+"+value2+"="+result);			
			
			//멀티 catch: 예외를 | 로 연결
			//JDK7.0 이상부터 하나의 catch블록에서 여러개의 예외를 처리할 수 있음.
		}catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("실행 매개값의 수가 부족하거나 숫자를 변환할 수 없습니다.");
		}catch(Exception e) {
			System.out.println("알 수 없는 예외 발생");
		}
	}
}
