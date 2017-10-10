package com.extention.s12;

interface Inter1{
	public int getA();
}
interface Inter2{
	public int getB();
}

//�������̽� Inter3�� �������̽� Inter1�� Inter2�� ���
//���߻�� ��������? -> �������̽��� ���ĸ� ������ �ֱ� ������
interface Inter3 extends Inter1, Inter2{
	public int getData();
}

public class InterMain04 implements Inter3 {
	public static void main(String[] args) {
		InterMain04 im = new InterMain04();
		System.out.println(im.getA());
		System.out.println(im.getB());
		System.out.println(im.getData());
	}

	@Override
	public int getA() {
		return 10;
	}

	@Override
	public int getB() {
		return 20;
	}

	@Override
	public int getData() {
		return 30;
	}
}
