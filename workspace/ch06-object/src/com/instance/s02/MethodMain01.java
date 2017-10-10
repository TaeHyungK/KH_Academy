package com.instance.s02;

public class MethodMain01 {
	String msg;
	
	//멤버변수에 데이터 전달
	public void setMsg(String m) {
		msg = m;
		return;//일반적으로 생략
	}
	
	//멤버변수의 값을 반환
	public String getMsg() {
		return msg;
	}
	
	//인자에 데이터가 전달되고 데이터를 반환
	public int add(int a, int b) {
		return a+b;
	}
	
	//인자에 데이터가 전달되고 반환하는 값이 없음
	public void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		MethodMain01 method = new MethodMain01();
		method.setMsg("서울");
		
		String city = method.getMsg();
		System.out.println("city = "+ city);
		
		int result = method.add(5, 8);
		System.out.println("result = "+ result);
		
		method.print("오늘은 목요일");
		
	}
}
