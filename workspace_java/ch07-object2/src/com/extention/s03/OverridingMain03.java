package com.extention.s03;

class People{
	
	//Method overriding(함수 재정의)
	@Override//어노테이션은 재정의 문법에 맞게 재정의가 되었는지 검증해줌.
	public String toString() {
		return "People";
	}
}

class Animal{
	
}
public class OverridingMain03 {
	public static void main(String[] args) {
		People p = new People();
		System.out.println(p.toString());
		Animal a = new Animal();
		System.out.println(a.toString());
		
	}
}
