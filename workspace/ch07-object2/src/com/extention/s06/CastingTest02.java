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
		//instanceof �����ڴ� ������ ��ü��
		//����� �ڷ������� ĳ������ �� �ִ���
		//���θ� üũ�ϴ� ������
//		   ��ü		     �ڷ���
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
		
		ct.add(new A()); //A -> Object ��ĳ����
		ct.add(new B()); //B -> Object ��ĳ����
		ct.add(new C()); //C -> Object ��ĳ����
	}
}
