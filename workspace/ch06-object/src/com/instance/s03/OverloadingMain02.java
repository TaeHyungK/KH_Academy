package com.instance.s03;

public class OverloadingMain02 {
	//메소드 오버로딩(중복정의)
	public void getLength(int a) {
		//int -> String
		String s = String.valueOf(a);
		//인자의 타입이 String인 메소드를 호출
		getLength(s);
	}
	public void getLength(float f) {
		//float -> String
		String s = String.valueOf(f);
		//인자의 타입이 String인 메소드를 호출
		getLength(s);
	}
	public void getLength(String str) {
		//String -> String
		System.out.println("입력한 값의 길이: " + str.length());
	}
	
	
	
	public static void main(String[] args) {
		OverloadingMain02 ot = new OverloadingMain02();
		
		ot.getLength(10000);
		ot.getLength(3.14f);
		ot.getLength("Hello!");
	}
}