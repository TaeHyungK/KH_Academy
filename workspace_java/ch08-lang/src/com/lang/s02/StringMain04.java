package com.lang.s02;

public class StringMain04 {
	public static void main(String[] args) {
		String s1 = "   aBa   ";
		String s2 = "abc";
		int a = 100;
		String msg = null;
		
		//대문자로 교체
		msg = s1.toUpperCase();
		System.out.println(msg);
		//소문자로 교체
		msg = s1.toLowerCase();
		System.out.println(msg);
		
		//특정 문자열을 다른 문자열로 교체
		msg = s1.replace("aB", "b");
		System.out.println(msg);
		
		//공백 제거 -> 중간 공백은 제거 불가능
		msg = s1.trim();
		System.out.println(msg);
		
		//문자열에서 특정 문자열이 포함되어 있는지 여부 체크
		boolean f = s1.contains("aB");
		System.out.println(f);
		
		//문자열에서 특정 문자열이 맨 앞에 있는지 여부 체크
		f = s2.startsWith("ab");
		System.out.println(f);
		
		//문자열에서 특정 문자열이 맨 뒤에 있는지 여부 체크
		f = s2.endsWith("cz");
		System.out.println(f);
		
//		int -> String
		msg = String.valueOf(a);
		msg = ""+a;
	}
}
