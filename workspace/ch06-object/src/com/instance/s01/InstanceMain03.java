package com.instance.s01;

public class InstanceMain03 {
	int var1;
	String var2;
	
	public int sum(int a,int b) {
		return a+b;
	}
	
	
	
	public static void main(String[] args) {
		InstanceMain03 me = new InstanceMain03();
		me.var1 = 10;
		me.var2 = "����";
		System.out.println(me.var1 + "," + me.var2);
		
		//����޼ҵ带 ȣ���ؼ� ���� �����ϰ� ������� ��ȯ ����
		int result = me.sum(10,20);
		System.out.println("result = "+result);
		
	}
}
