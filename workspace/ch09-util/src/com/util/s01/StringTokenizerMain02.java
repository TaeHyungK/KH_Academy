package com.util.s01;

import java.util.StringTokenizer;

public class StringTokenizerMain02 {
	public static void main(String[] args) {
		String source = "2017-09-14 11:39:45";
		
		StringTokenizer st = new StringTokenizer(source, "-: ");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
