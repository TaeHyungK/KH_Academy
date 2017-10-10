package com.extention.s03;

class Mother{
	public String getLunch() {
		return "¹ä";
	}
}

class Son extends Mother {
	
}
class Daughter extends Mother{
	//Method Overriding(ÇÔ¼ö ÀçÁ¤ÀÇ)
	public String getLunch() {
		return "»§";
	}
}
public class OverridingMain02 {
	public static void main(String[] args) {
		Son s = new Son();
		System.out.println("¾ÆµéÀº " + s.getLunch() + "À» ¸Ô´Â´Ù.");
		Daughter d = new Daughter();
		System.out.println("µþÀº " + d.getLunch() + "À» ¸Ô´Â´Ù.");
		
	}
}
