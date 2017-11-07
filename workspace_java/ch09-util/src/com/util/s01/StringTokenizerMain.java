package com.util.s01;

import java.util.StringTokenizer;

public class StringTokenizerMain {
	public static void main(String[] args) {
		String source = "100,200,300,400";
		
		//구분자는 제거하고 데이터를 읽음
		StringTokenizer st = new StringTokenizer(source,",");
		
		//hasMoreToken(): 구분자로 잘린 문자열이 있는지 true false 반환
		while(st.hasMoreTokens()) {
			//nextToken(): 구분자로 잘란낸 문자열을 읽어들여 반환.
			System.out.println(st.nextToken());
		}
		
	}
}
