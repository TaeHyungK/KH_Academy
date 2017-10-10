package com.instance.s01;

public class InstanceMain03 {
	int var1;
	String var2;
	
	public int sum(int a,int b) {
		return a+b;
	}
	
	
	
	public static void main(String[] args) {
		InstanceMain03 me = new InstanceMain03();
		me.var1 = 10;
		me.var2 = "수학";
		System.out.println(me.var1 + "," + me.var2);
		
		//멤버메소드를 호출해서 값을 전달하고 결과값을 반환 받음
		int result = me.sum(10,20);
		System.out.println("result = "+result);
		
	}
}
