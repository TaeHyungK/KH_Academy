package com.extention.s11;

//�߻�Ŭ������ ��ü ���� �Ұ���
abstract class A{
	int x = 10;
	int y;
	
	public void setY(int y) {
		this.y = y;
	}
	
	//�߻�޼ҵ�: �̱����� �޼ҵ�
	abstract public void abc();
}

class B extends A{

	//�߻�޼ҵ� ����
	//�θ�Ŭ������ �߻�޼ҵ尡 ���ԵǾ������� �ݵ�� �ڽ�Ŭ��������
	//�߻�޼ҵ带 �Ϲݸ޼ҵ�� �����ؾ� ��
	@Override
	public void abc() {
		System.out.println("abc �޼ҵ�");
	}

}
public class AbstractMain01 {
	public static void main(String[] args) {
//		A ap = new A();
		B bp = new B();
		
		bp.abc();
	}
}
