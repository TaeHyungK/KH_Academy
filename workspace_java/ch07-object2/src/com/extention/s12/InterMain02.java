package com.extention.s12;

//�������̽� : ���ĸ� �ְ� ������ ����
interface A2{
	public abstract void getA(); //����
	void getB(); // �������̽��� public abstract �����Ǿ� ����
}

//�Ϲ�Ŭ������ �������̽��� ����
class B2 implements A2{
	//�������̽��� �߻�޼ҵ� ����
	@Override
	public void getA() {
		System.out.println("getA �޼ҵ�");
	}

	@Override
	public void getB() {
		System.out.println("getB �޼ҵ�");
	}
	
}

public class InterMain02 {
	public static void main(String[] args) {
		
	}
}
