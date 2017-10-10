package com.exception.s01;

public class ExceptionMain01 {
	public static void main(String[] args) {
		int[] array = {100,200,300};
		
		//인덱스 3은 없는데 인덱스 3을 호출해서 예외 발생
		for(int i=0;i<=array.length;i++) {
			System.out.println("array["+i+"]: "+array[i]);
		}
		
		System.out.println("프로그램 끝");
	}
}
