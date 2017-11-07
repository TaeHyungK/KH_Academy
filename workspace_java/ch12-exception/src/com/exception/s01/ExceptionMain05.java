package com.exception.s01;

public class ExceptionMain05 {
	public static void main(String[] args) {
		System.out.println("예외가 발생하지 않았을 경우");
		try {
			System.out.println("1");
			System.out.println("2");
		}catch(Exception e){
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
		System.out.println("프로그램 종료");
		System.out.println("------------------");
		
		try {
			System.out.println("1");
			System.out.println(10/0); //예외 발생
			System.out.println("2"); //미실행
		}catch(Exception e) {
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
		System.out.println("프로그램 종료");
		System.out.println("------------------");
		
	}
}
