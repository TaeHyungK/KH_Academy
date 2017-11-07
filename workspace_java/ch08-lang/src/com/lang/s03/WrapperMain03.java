package com.lang.s03;

public class WrapperMain03 {
	public static void main(String[] args) {
//		int는 0으로 나눌 수 없음
//		int a = 5;
//		int b= 0;
//		System.out.println(a/b);
		
		double x = 5.0;
		double y = 0.0;
		
		double z = x/y;
		System.out.println(z);
		
		//isFinite() : 나눠서 몫을 구할 수 있으면 true 반환
		if(Double.isFinite(z)) {
			System.out.println("몫: " + z);
		}else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}
}
