package com.instance.s03;

public class OverloadingMain01 {
	//�޼ҵ� �����ε�(method Overloading, �ߺ�����)
	//�޼ҵ��� �̸��� ���� ���޵Ǵ� ������ Ÿ��, ����, ���� ���� �ٸ���
	//��������ν� �޼ҵ尡 �浹���� �ʰ� ȣ��Ǵ� ���
	//�޼ҵ��� ����� ������ ���� �޼ҵ���� ��������ν� �޼ҵ��� �����
	//ȿ�������� �� �� �ִ�.
	
	
	public void print(int n) {
		System.out.println("���� n= " + n);
	}
	public void print(double n) {
		System.out.println("�Ǽ� n= " + n);
	}
	public void print(double n, long a) {
		System.out.println("�Ǽ� n= "+n +", " + "���� a= " +a);
	}
	public void print(long a, double n) {
		System.out.println("���� a= "+a+", "+"�Ǽ� n= "+n);
	}
	
	public static void main(String[] args) {
		OverloadingMain01 ot = new OverloadingMain01();
		
		ot.print(3);
		ot.print(3.0);
		ot.print(3.2, 237509235L);
		ot.print(59803L,1.8);
	}
}
