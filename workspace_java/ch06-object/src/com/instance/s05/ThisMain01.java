package com.instance.s05;

public class ThisMain01 {
	
	//this: ��ü ���ο��� ��ü�� �����ϴ� ���� ������ ���� ����
	public ThisMain01() {
		System.out.println("��ü ����: " + this);
	}
	
	public static void main(String[] args) {
		ThisMain01 tm = new ThisMain01();
		System.out.println("��ü ���� ��: " + tm);
		
	}
}
