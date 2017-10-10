package com.packtwo;

import com.packone.People;

class Student extends People{
	public void print() {
//		System.out.println("a: " + a);//a는 private, 같은 클래스가 아니여서 못 불러옴
//		System.out.println("b: " + b);//b는 default, 같은 패키지가 아니여서 못 불러옴
		System.out.println("c: " + c);//c는 protected, 다른 패키지더라도 상속 관계면 불러올 수 있음
		System.out.println("d: " + d);//d는 public
	}
}

public class AccessMain02 {
	public static void main(String[] args) {
		Student s = new Student();
//		System.out.println(s.a);//private, 같은 클래스가 아님
//		System.out.println(s.b);//default, 같은 패키지가 아님
//		System.out.println(s.c);//protected, 같은 패키지도 아니고 상속관계도 아님(AccessMain02와 People이 ) 
		System.out.println(s.d);//public, 
	}
}
