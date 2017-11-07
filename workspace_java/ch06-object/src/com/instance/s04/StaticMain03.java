package com.instance.s04;

class StaticMethod {
	String s1 = "instance";
	static String s2 = "static";

	public static String getString() {
		return s2;
	}
}

public class StaticMain03 {
	public static void main(String[] args) {
		System.out.println(StaticMethod.getString());
		System.out.println(new StaticMethod().s1);
	}
}
