package com.extention.s11;
//�߻�Ŭ����
abstract class AbsEx1{
	int a = 100;
	public int getA() {
		return a;
	}
	//�߻�޼ҵ�
	abstract public String getStr();
	public abstract int getB();
}

abstract class AbsEx2 extends AbsEx1{
	String msg = "�ż���";
	@Override
	public String getStr() {
		return msg;
	}
	//�߻�޼ҵ�
	abstract public int getC();
}



public class AbstractMain02 extends AbsEx2{
	public static void main(String[] args) {
		AbstractMain02 ab = new AbstractMain02();
		System.out.println(ab.getA());
		System.out.println(ab.getStr());
		System.out.println(ab.getB());
		System.out.println(ab.getC());
		
	}

	//�θ�Ŭ������ �߻�޼ҵ带 �ݵ�� ����
	@Override
	public int getC() {
		return 20;
	}

	@Override
	public int getB() {
		return 30;
	}
}
