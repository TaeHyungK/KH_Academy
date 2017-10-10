package com.inner.s01;

public class InnerMain01 {
	
	//static ���� Ŭ����
	//static ���� Ŭ������ ������ Ŭ������ ��ü ��������
	// static ���� Ŭ���� ��ü�� ����
	//static ����Ŭ������ static ����, �޼ҵ带 ������ �� ����
	public static class StaticInner{
		int iv = 200;
		static int cv = 300;
		static void make() {
			System.out.println("����");
		}
	}
	
	public static void main(String[] args) {
		InnerMain01.StaticInner i = new InnerMain01.StaticInner();
		System.out.println(i.iv);
		
		//static ���� ȣ��
		System.out.println(InnerMain01.StaticInner.cv);
		
		//static �޼ҵ� ȣ��
		InnerMain01.StaticInner.make();
	}
}
