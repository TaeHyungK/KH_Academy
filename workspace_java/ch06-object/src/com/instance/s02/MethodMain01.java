package com.instance.s02;

public class MethodMain01 {
	String msg;
	
	//��������� ������ ����
	public void setMsg(String m) {
		msg = m;
		return;//�Ϲ������� ����
	}
	
	//��������� ���� ��ȯ
	public String getMsg() {
		return msg;
	}
	
	//���ڿ� �����Ͱ� ���޵ǰ� �����͸� ��ȯ
	public int add(int a, int b) {
		return a+b;
	}
	
	//���ڿ� �����Ͱ� ���޵ǰ� ��ȯ�ϴ� ���� ����
	public void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		MethodMain01 method = new MethodMain01();
		method.setMsg("����");
		
		String city = method.getMsg();
		System.out.println("city = "+ city);
		
		int result = method.add(5, 8);
		System.out.println("result = "+ result);
		
		method.print("������ �����");
		
	}
}
