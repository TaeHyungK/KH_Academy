package com.extention.s05;

class A{}
class B{}
class C{}
class D{}

public class CastingTest01 {
//	public void add(A a) {}
//	public void add(B b) {}
//	public void add(C c) {}

	public void add(Object o) {}
	
	public static void main(String[] args) {
		CastingTest01 ct = new CastingTest01();
		ct.add(new A()); // A->Object 형변환
		ct.add(new B()); // B->Object 형변환
		ct.add(new C()); // C->Object 형변환
		ct.add(new D()); // D->Object 형변환
		
		
		
	}
}
