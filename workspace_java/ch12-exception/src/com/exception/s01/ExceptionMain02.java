package com.exception.s01;

public class ExceptionMain02 {
	public static void main(String[] args) {
		int[] array = {100,200,300};
		
		//예외처리
		//예외가 발생해도 정상적으로 종료가 될 수 있도록
		for(int i=0;i<=array.length;i++) {
			try {
				//예외가 발생할 가능성이 있는 코드를 명시
				//만약 예외가 발생하면 예외가 발생한 코드의 실행을 멈추고
				//catch블럭으로 이동
				System.out.println("array["+i+"]: "+array[i]);
				//위 코드에서 예외가 발생하면 실행되지 않음
				System.out.println("~~~~~");
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 인덱스가 없습니다.");
			}
		}//end of for
		
		System.out.println("프로그램 끝");
		
		
	}
}
