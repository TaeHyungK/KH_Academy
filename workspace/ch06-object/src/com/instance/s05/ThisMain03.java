package com.instance.s05;

public class ThisMain03 {
	
	//this() : ������ ���ο��� �� �ٸ� �����ڸ� ȣ���� �� ���
	public ThisMain03() {
//		System.out.println("~~~~"); -> this()�� �׻� �� ���� �־�� ��
		this("�ٶ�");
	}
	public ThisMain03(String msg) {
		System.out.println(msg);
	}
	public ThisMain03(int a) {
		this(String.valueOf(a));
//		this(Integer.toString(a));
	}
	
	public static void main(String[] args) {
		ThisMain03 tm1 = new ThisMain03();
		ThisMain03 tm2 = new ThisMain03("���� ����");
		ThisMain03 tm3 = new ThisMain03(1241);
		
		
	}
}
