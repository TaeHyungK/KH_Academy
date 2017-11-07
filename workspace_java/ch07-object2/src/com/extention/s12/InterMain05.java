package com.extention.s12;

interface InterA{
	public void make();
}

class InterEx2 implements InterA{
	
	@Override
	public void make() {
		System.out.println("make �޼ҵ�");
	}
	
	public void fun() {
		System.out.println("fun �޼ҵ�");
	}
}


public class InterMain05 implements InterA{
	public static void main(String[] args) {
		InterEx2 ie = new InterEx2();
		
		ie.make();
		ie.fun();
		
		//Ŭ����Ÿ�� -> �������̽�Ÿ�� ����ȯ
		//�ڵ������� ����ȯ
		InterA a = ie;
		a.make();
		//ȣ�� ������ ��� ȣ�� �Ұ�
		//a.fun();
		
		//�������̽�Ÿ�� -> Ŭ����Ÿ�� ����ȯ
		//��������� ����ȯ
		InterEx2 ie2 = (InterEx2) a;
		ie2.make();
		ie2.fun();
	}
	
	

	@Override
	public void make() {
		System.out.println("make �޼ҵ�");
	}
	public void fun() {
		System.out.println("fun �޼ҵ�");
	}
}
