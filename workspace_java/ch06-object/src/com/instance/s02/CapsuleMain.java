package com.instance.s02;

class Capsule{
	//����ȭ
	//���� Ŭ������������ ȣ�� ����
	private int a;
	
	//ĸ��ȭ
	public void setA(int n) {
		if(n>=0)
			a = n;
		else
			System.out.println("������ ������ �ʽ��ϴ�.");
	}
	
	public int getA() {
		return a;
	}
	
}

public class CapsuleMain {
	public static void main(String[] args) {
		Capsule cap = new Capsule();
		//���� a�� ���� �����ڰ� private�̱� ������ ���� Ŭ���� �������� ȣ���� ����������
		//�ٸ� Ŭ�������� ȣ�� �Ұ���
//		cap.a = -1;
//		System.out.println(cap.a);
		
		cap.setA(100);
		System.out.println(cap.getA());
		System.out.println("------------------");
		
		cap.setA(-200);
		System.out.println(cap.getA());
		
		
	}
}
