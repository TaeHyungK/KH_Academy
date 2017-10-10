package com.lang.s02;

public class StringBufferMain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("여름 덥다!!");
		
		System.out.println("1: " + sb);
		
		//지정한 인덱스에 문자 삽입
		sb.insert(2, '이');
		System.out.println("2: " + sb);
		
		//기존 문자열 뒤에 문자열 추가
		sb.append("가을은 ");
		System.out.println("3: " + sb);
		
		sb.append("시원하다");
		System.out.println("4: " + sb);
		
		//인덱스를 명시해서 인덱스 범위안의 문자열을 새로운 문자열로 교체
		//start ~ (end-1) 인덱스까지  
		sb.replace(0, 3, "여행가자!!");
		System.out.println("5: " + sb);
		
		//인덱스를 지정해서 해당 문자를 삭제
		sb.deleteCharAt(0);
		System.out.println("6: " + sb);
		
		//인덱스를 지정해서 해당 문자열을 삭제
		//start ~ (end-1)인덱스 까지
		sb.delete(0, 3);
		System.out.println("7: " + sb);
		
		String str = sb.toString();
		System.out.println("str: " + str);
	}
}
