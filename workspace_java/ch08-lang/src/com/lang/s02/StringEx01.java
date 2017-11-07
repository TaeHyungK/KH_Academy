package com.lang.s02;

public class StringEx01 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�] �빮�� -> �ҹ��ڷ�, �ҹ��� -> �빮�ڷ�
		 * 
		 * ��¿���
		 * ABCmdYE-4w?ewZZ
		 * tip) ctrl + shift + 'x' = �빮�ڷ�
		 *                   + 'y' = �ҹ��ڷ�   ����Ű
		 */
		
		String str = "abcMDye-4W?EWzz";
		String result = "";
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>=65 && str.charAt(i)<=90) {
				result += String.valueOf(str.charAt(i)).toLowerCase();
			}else if(str.charAt(i)>=97 && str.charAt(i)<=122) {
				result += String.valueOf(str.charAt(i)).toUpperCase();
			}else {
				result += str.charAt(i);
			}
		}
		
		System.out.println(result);
		
		System.out.println("---------------------");
		
		String result2 = "";
		for(char c : str.toCharArray()) {
			if(Character.isUpperCase(c)) {
				result2 += Character.toLowerCase(c);
			}else if(Character.isLowerCase(c)) {
				result2 += Character.toUpperCase(c);
			}else {
				result2 += c;
			}
		}
		
		System.out.println(result2);
		
	}
}
