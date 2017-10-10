package com.extention.s06;
class A{
	public void make() {
		System.out.println("make");
	}
}
class B{
	public void play() {
		System.out.println("play");
	}
}
class C{
	public void fun() {
		System.out.println("fun");
	}
}
public class CastingTest02 {
	public void add(Object o) {
		//instanceof 연산자는 지정한 객체를
		//명시한 자료형으로 캐스팅할 수 있는지
		//여부를 체크하는 연산자
//		   객체		     자료형
		if(o instanceof A) {
			A a = (A)o;
			a.make();
		}else if(o instanceof B) {
			B b = (B)o;
			b.play();
		}else if(o instanceof C) {
			C c = (C)o;
			c.fun();
		}
	}
	
	public static void main(String[] args) {
		CastingTest02 ct = new CastingTest02();
		
		ct.add(new A()); //A -> Object 업캐스팅
		ct.add(new B()); //B -> Object 업캐스팅
		ct.add(new C()); //C -> Object 업캐스팅
	}
}
