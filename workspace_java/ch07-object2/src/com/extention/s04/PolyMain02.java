package com.extention.s04;

class A{
	public void make() {
		System.out.println("make �޼ҵ�");
	}
}
class B extends A{
	public void play() {
		System.out.println("play �޼ҵ�");
	}
}

public class PolyMain02 {
	public static void main(String[] args) {
		B bp = new B();
		bp.make();
		bp.play();
		
		//�ڽ�Ŭ���� Ÿ�� -> �θ�Ŭ���� Ÿ��
		//��ĳ����, �ڵ� ����ȯ
		A ap = bp;
		ap.make();
		//ȣ�� ������ ��� ȣ�� �Ұ���
//		ap.play();
		
		//�θ�Ŭ���� Ÿ�� -> �ڽ�Ŭ���� Ÿ��
		//�ٿ�ĳ����, ����� ����ȯ
		B bp2 = (B)ap;
		bp2.make();
		bp2.play();
		
	}
}
