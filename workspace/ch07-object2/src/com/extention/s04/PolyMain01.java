package com.extention.s04;

class Parent{
	int a= 100;
}

class Child extends Parent{
	int b= 200;
}

public class PolyMain01 {
	public static void main(String[] args) {
		//��ü�� ��� ���谣�� ����ȯ ����
		Child ch = new Child();
		System.out.println(ch.a);
		System.out.println(ch.b);
		System.out.println("--------------");
		
		//�ڽ�Ŭ���� Ÿ�� -> �θ�Ŭ���� Ÿ�� ����ȯ
		//��ĳ����, �ڵ������� ����ȯ
		Parent p = ch;
		System.out.println(p.a);
		System.out.println("--------------");
		//ȣ�� ������ ��� ȣ�� �Ұ�
//		System.out.println(p.b);
		
		//�θ�Ŭ���� Ÿ�� -> �ڽ�Ŭ����Ÿ�� ����ȯ
		//�ٿ�ĳ����, "�����"���� ����ȯ
		Child ch2 = (Child) p;
		System.out.println(ch2.a);
		System.out.println(ch2.b);
		
		
	}
}
