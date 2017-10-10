package com.exception.s01;

import java.util.Scanner;

//사용자 정의 예외 클래스
//Exception을 상속받아서 예외클래스 정의
class MinusNumberUseException extends Exception{
	public MinusNumberUseException(String str) {
		super(str);
	}
}

public class MinusNumberUseExceptionMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("0이상만 입력: ");
		try {
			int a= input.nextInt();
			if(a>=0) {
				System.out.println("입력한 숫자: " + a);
			}else {
				//사용자가 정의한 예외를 인위적으로 발생시킴
				throw new MinusNumberUseException("음수가 입력되었습니다.");
			}
		}catch(MinusNumberUseException e){
			System.out.println(e.getMessage());
		}finally {
			//자원 정리
		}
		
	}
}
