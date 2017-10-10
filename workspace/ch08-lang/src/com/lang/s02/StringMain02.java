package com.lang.s02;

public class StringMain02 {
	public static void main(String[] args) {
		String str1 = "bus";
		String str2 = "BUS";
		
		//대소문자 구분 문자열 비교
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 문자열");
		}else {
			System.out.println("str1과 str2는 다른 문자열");
		}
		
		//대소문자 구별없이 문자열 비교
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("str1과 str2는 같은 문자열");
		}else {
			System.out.println("str1과 str2는 다른 문자열");
		}
		
		
	}
}
