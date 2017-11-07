package com.packtwo;

import com.packone.People;

public class AccessMain01 {
	public static void main(String[] args) {
		People p = new People();
//		System.out.println(p.a); -> a의 접근지정자가 private여서
//		System.out.println(p.b); -> b의 접근지정자가 default, default변수는 같은 패키지 내에서만 호출 가능
//		System.out.println(p.c); -> c의 접근지정자가 protected, protected변수는 같은 패키지일때 상속관계일 때 호출 가능
		System.out.println(p.d); //-> d의접근지정자가 public, 모든 곳에서 접근 가능
	}
}
