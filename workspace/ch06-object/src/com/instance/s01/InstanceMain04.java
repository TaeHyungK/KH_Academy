package com.instance.s01;

public class InstanceMain04 {
	//멤버필드
	//변수
	int num;
	//상수
	final int MAX_NUM = 100;
	
	public int multi(int x, int y) {
		return x*y;
	}
	
	//생성자
	//객체 생성시 호출되어 멤버변수를 초기화하는 역할을 수행
	//컴파일러에서 기본 생성자는 자동으로 생성해줌.
	public InstanceMain04() {
		
	}
	
	public static void main(String[] args) {
		InstanceMain04 in = new InstanceMain04();
		in.num=5;
		//in.MAX_NUM = 1; -> 상수는 변경 불가능
		
		System.out.println(in.num + "," + in.MAX_NUM);
		
		//멤버메소드에 값을 전달하고 결과값을 받환 받음
		int result = in.multi(5, 7);
		System.out.println("result = "+result);
	} 
}
