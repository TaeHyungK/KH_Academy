package com.extention.s07;
class Parent{
	public void make() {
		System.out.println("�θ�Ŭ������ make");
	}
	public void play() {
		System.out.println("�θ�Ŭ������ play");
	}
	public void fun() {
		System.out.println("�θ�Ŭ������ fun");
	}
}

class A extends Parent{
	@Override
	public void make() {
		System.out.println("�ڽ�Ŭ������ make");
	}
}

class B extends Parent{
	@Override
	public void play() {
		System.out.println("�ڽ�Ŭ������ play");
	}
}

class C extends Parent{
	@Override
	public void fun() {
		System.out.println("�ڽ�Ŭ������ fun");
	}
}
public class CastingTest03 {
	public void add(Parent p) {
		if(p instanceof A) {
			//�ٿ�ĳ������ ���� �ʾƵ� �޼ҵ� �������̵��� �̿��ؼ� �����ǵ� �޼ҵ� ȣ��
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
