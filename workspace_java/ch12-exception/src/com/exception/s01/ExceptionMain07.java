package com.exception.s01;

public class ExceptionMain07 {
	public static void main(String[] args) {
		ExceptionMain07 em = new ExceptionMain07();
		try {
			em.methodA(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void methodA(String[] n) throws Exception{
		if (n.length > 0) {
			// 확장 for문
			for (String s : n)
				System.out.println(s);

		}else {
			//예외 강제 발생
			throw new Exception("배열에 요소가 없습니다.");
		}

	}
}
