package com.inner.s02;

class Inner7 {
	public void disp() {
		System.out.println("Inner7�� disp");
	}
}

public class AnonyMain03 {

	public void innerTest() {
		//�͸� ���� Ŭ����
		//������ �ڿ� ���߰�ȣ�ڰ� ������ �͸� ����Ŭ������ �̿��� �͸� ��ü�� ������ ��!!
		//�͸���Ŭ������ Ŭ�������� ���� ������ �θ�Ŭ���� Ÿ���� ����ϰ� �ǹǷ�
		//�����ǵ� �޼ҵ常 ȣ�� ����
		Inner7 i = new Inner7(){
			//�θ�Ŭ������ �޼ҵ� ������
			@Override
			public void disp() {
				System.out.println("�͸�ü�� disp");
			}
			public void make() {
				System.out.println("make �޼ҵ�");
			}
		};
		
		i.disp();
		//ȣ�� ������ ����� ȣ�� �Ұ�
//		i.make();
		
	}

	public static void main(String[] args) {
		AnonyMain03 am = new AnonyMain03();
		am.innerTest();
	}
}
