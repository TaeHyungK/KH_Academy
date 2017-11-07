package com.lang.s04;

public class NumberCheckMain {
	public static void main(String[] args) {
		/*
		 * [실습] 문자열 데이터에 문자가 포함되어있는지 여부 확인
		 */
		String str = "1321ty556";
		String result ="";
		
		//문자가 포함되어 있으면 result="문자 포함"
		//포함되어 있지 않으면 result="숫자임"
		NumberCheckMain nc = new NumberCheckMain();
		
		//1번째 방법
		try {
			nc.test(str);
			
			result = "숫자임";
		}catch(NumberFormatException e) {
			result = "문자 포함";
		}finally {
			System.out.println(result);
			System.out.println("-----------");
		}
		
		//2번째 방법
		result = "숫자임";
		for(char c : str.toCharArray()) {
			if(!Character.isDigit(c)) {//숫자가 아닐경우
				result = "문자가 포함됨";
				break;
			}
		}
		System.out.println(result);
		System.out.println("-----------");
		
		//3번째 방법
		result = "숫자임";
		for(int i=0;i<str.length();i++) {
			char c= str.charAt(i);
			if(c <48 || c>57) {
				result = "문자가 포함됨";
				break;
			}
		}
		System.out.println(result);
	}
	
	public void test(String str) throws NumberFormatException {
		Integer.parseInt(str);
	}
}
