package com.extention.s07;
class Parent{
	public void make() {
		System.out.println("부모클래스의 make");
	}
	public void play() {
		System.out.println("부모클래스의 play");
	}
	public void fun() {
		System.out.println("부모클래스의 fun");
	}
}

class A extends Parent{
	@Override
	public void make() {
		System.out.println("자식클래스의 make");
	}
}

class B extends Parent{
	@Override
	public void play() {
		System.out.println("자식클래스의 play");
	}
}

class C extends Parent{
	@Override
	public void fun() {
		System.out.println("자식클래스의 fun");
	}
}
public class CastingTest03 {
	public void add(Parent p) {
		if(p instanceof A) {
			//다운캐스팅을 하지 않아도 메소드 오버라이딩을 이용해서 재정의된 메소드 호출
			p.make();
		}else if(p instanceof B) {
			p.play();
		}else if(p instanceof C) {
			p.fun();
		}
		
	}
	
	public static void main(String[] args) {
		CastingTest03 ct = new CastingTest03();
		ct.add(new A());//A->Parent
		ct.add(new B());//B->Parent
		ct.add(new C());//C->Parent
		
		
	}

}
