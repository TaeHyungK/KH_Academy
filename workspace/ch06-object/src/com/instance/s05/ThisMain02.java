package com.instance.s05;

class ThisTest {
	// ����ȭ
	private int a;

	// ĸ��ȭ
	
	//����������� ����������� �����ϸ� �������� ���������� �켱 ����
	public int getA() {
		return a;
	}

	public void setA(int a) {
	//this�� ��ü ���ο��� ��ü�� �����ϴ� ���������� ������ �ϱ� ������ �����������
	//����������� ���� �� ����������� ��Ī�ϰ��� ����� �� ����
	   //�������  ��������
		this.a = a;
	}
}

public class ThisMain02 {
	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		tt.setA(10);
		System.out.println(tt.getA());
	}
}
