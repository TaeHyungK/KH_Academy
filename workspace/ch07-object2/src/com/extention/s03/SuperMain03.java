package com.extention.s03;

class Parent2{
	int a;
	public Parent2(int a) {
		this.a = a;
	}
}
class Child2 extends Parent2{
	
	public Child2() {
		//�θ�Ŭ������ ����Ʈ �����ڰ� ���� ���ڰ� ��õ� �����ڸ� ������ ���
		//��������� super(�Ķ����)�� �̿��ؼ� �����ڸ� ȣ���ϰ� �����͸� �����ؾ� ��.
		super(100);
	}
	
}

public class SuperMain03 {
	public static void main(String[] args) {
		
	}
}
