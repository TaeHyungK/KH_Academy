package com.inner.s01;

public class LocalMain02 {
	int a = 100; // �������
	
	public void innerTest() {
		//JDK7.0���Ͽ����� ���������� ����Ŭ�������� ȣ���� �� ���� ������
		//final�� ����� ���ȭ�ؾ� ��
		
		int b = 200; // ��������
		
		//���� ����Ŭ����
		class Inner{
			int c = 300; // ����Ŭ������ �������
			public void getData() {
				//���ó���Ŭ�������� ���������� ȣ���� ���� JDK8.0���� �ڵ�����
				//���ȭ ��Ű�� ������ ���� ������ �� ����
//				b= 400;
				
				System.out.println("a: " + a);
				System.out.println("b: " + b);
				System.out.println("c: " + c);
			}
		}
		
		Inner i = new Inner();
		i.getData();
	}
	
	public static void main(String[] args) {
		LocalMain02 m = new LocalMain02();
		m.innerTest();
	}
}
