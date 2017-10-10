package com.extention.s08;


class Parent{
	public void work() {
		System.out.println("�θ�Ŭ������  work");
	}
}

class A extends Parent{
	@Override
	public void work() {
		System.out.println("�ڽ�Ŭ������ work");
	}
}

class B extends Parent{
	@Override
	public void work() {
		System.out.println("�ڽ�Ŭ������ play");
	}
}

class C extends Parent{
	@Override
	public void work() {
		System.out.println("�ڽ�Ŭ������ fun");
	}
}
public class CastingTest04 {
	public void add(Parent p) {
		p.work();
	}
	
	public static void main(String[] args) {
		CastingTest04 ct = new CastingTest04();
		ct.add(new A());//A->Parent
		ct.add(new B());//B->Parent
		ct.add(new C());//C->Parent
		
		
	}

}
