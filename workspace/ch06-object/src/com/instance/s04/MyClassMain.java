package com.instance.s04;

public class MyClassMain {
	int a;
	int b;
	
	public MyClassMain(int n,int m) {
		//�����ڴ� ��ü�� ������ �� ��������� �ʱ�ȭ �ϴ� ������ ������
		//�� �ܿ� ����� ����ؼ� ������ üũ�ϰų� �ݺ����� �̿��� �۾���
		//������ ���� �ְ� Ư�� �޼ҵ带 ȣ���� ���� ����
		
		//������� �ʱ�ȭ
		a = n;
		b = m;
		
		//������ ���
		if(n>0) {
			System.out.println(n+"�� ��� �Դϴ�.");
		}else {
			System.out.println(n+"�� ����� �ƴմϴ�.");
		}
		
		if(m>0) {
			System.out.println(m+"�� ��� �Դϴ�.");
		}else {
			System.out.println(m+"�� ����� �ƴմϴ�.");
		}
		
	}
	
	public static void main(String[] args) {
		MyClassMain mc = new MyClassMain(-10, 20);
	}
}
