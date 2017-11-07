package com.lang.s02;

public class StringMain03 {
	public static void main(String[] args) {
		String s1 = "Kwon Sun Ae";
//					 012345678910 -> 11
		int index = s1.indexOf('n');
		System.out.println("맨 처음 문자 n의 위치: " + index);
		
		index = s1.indexOf("Sun");
		System.out.println("문자열 Sun의 위치: " + index);
		
		index = s1.lastIndexOf('n');
		System.out.println("마지막 문자 n의 위치: " + index);
		
		char c = s1.charAt(index); // 문자 추출
		System.out.println("추출한 문자: " + c);
		
		index = s1.indexOf('S');
		String str = s1.substring(index); //부분 문자열 추출
		System.out.println("대문자 S부터 끝까지 문자열: " + str);
		
		//substring(시작인덱스,끝인덱스): 시작인덱스 ~ (끝인덱스-1)까지 출력
		str = s1.substring(index, (index+3));
		System.out.println("대문자 S부터 3칸 문자열: " + str);
		
		int length = s1.length();
		System.out.println("s1의 길이: " + length);
		
		String[] array = s1.split(" ");
		for(int i=0;i<array.length;i++) {
			System.out.println("array["+i+"]: "+array[i]);
		}
	}
}
