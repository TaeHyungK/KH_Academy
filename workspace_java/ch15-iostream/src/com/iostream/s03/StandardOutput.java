package com.iostream.s03;

public class StandardOutput {
	public static void main(String[] args) {
		//표준 출력
		System.out.println("Hello Wolrd!");
		
		//표준 에러 출력
		try {
			System.out.println(5/0);
		}catch(Exception e) {
			//붉은 글씨로 표시
			System.err.println("0으로 나눌 수 없습니다.");
			
		}
	}
}
