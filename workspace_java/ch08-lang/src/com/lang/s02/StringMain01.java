package com.lang.s02;

public class StringMain01 {
	public static void main(String[] args) {
		//암시적 String 생성
		String str1 = "abc";
		String str2 = "abc";
//		System.out.println(str1.toString()); 
//		//String의 toString()은 재정의됨
//		System.out.println(str2);
		
		//객체 비교
		if(str1 == str2) {
			System.out.println("str1과 str2는 같은 객체");
		}else {
			System.out.println("str1과 str2는 다른 객체");
		}
		
		//문자열 비교 -> String의 equals메소드는 재정의 되었음.
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 문자열");
		}else {
			System.out.println("str1과 str2는 다른 문자열");
		}
		System.out.println("-------------");
		
		//명시적 String 생성
		String str3= new String("Hello");
		String str4= new String("Hello");
		
		//객체 비교
		if(str3 == str4) {
			System.out.println("str3과 str4는 같은 객체");
		}else {
			System.out.println("str3과 str4는 다른 객체");
		}
		
		//문자열 비교 -> String의 equals메소드는 재정의 되었음.
		if(str3.equals(str4)) {
			System.out.println("str3과 str4는 같은 문자열");
		}else {
			System.out.println("str3과 str4는 다른 문자열");
		}
		
		
	}
}
