package com.instance.s01;

public class InstanceMain02 {
	int var1;
	String var2;
	
	public static void main(String[] args) {
		//��ü ����
		//InstanceMain02 : �����ڷ���
		//me : ���ʺ���
		InstanceMain02 me;
		
		//��ü ����
		//new : ��ü ������ ȣ���ϴ� ������
		//InstanceMain02() : ������
		me = new InstanceMain02();
		
		System.out.println(me);
		System.out.println(me.var1);
		System.out.println(me.var2);
		
		me.var1=10;
		me.var2="����";
		System.out.println(me.var1);
		System.out.println(me.var2);
		
	}
}
