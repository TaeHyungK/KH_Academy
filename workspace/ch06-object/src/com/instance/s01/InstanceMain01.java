package com.instance.s01;

public class InstanceMain01 {
	//멤버 필드(=변수)
	int a;
	boolean b;
	float c;
	
	public static void main(String[] args) {
		InstanceMain01 im = new InstanceMain01();
		System.out.println(im.a);
		System.out.println(im.b);
		System.out.println(im.c);
		
		System.out.println("-----------");
		
		//멤버 변수의 값 변경
		im.a = 10;
		im.b = true;
		im.c = 4.5f;
		System.out.println(im.a);
		System.out.println(im.b);
		System.out.println(im.c);
		
	}
}
