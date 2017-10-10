package com.lang.s01;

public class ObjectMain01 {
	public static void main(String[] args) {
		ObjectMain01 ob = new ObjectMain01();

		System.out.println(ob.getClass());
		System.out.println(ob.getClass().getName());
		System.out.println(ob.hashCode()); //10진수 해시코드
		System.out.println(Integer.toHexString(ob.hashCode())); // 16진수 해시코드
		System.out.println(ob.toString());
		System.out.println(ob);
		
	}
}
