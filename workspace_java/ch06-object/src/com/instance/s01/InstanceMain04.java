package com.instance.s01;

public class InstanceMain04 {
	//����ʵ�
	//����
	int num;
	//���
	final int MAX_NUM = 100;
	
	public int multi(int x, int y) {
		return x*y;
	}
	
	//������
	//��ü ������ ȣ��Ǿ� ��������� �ʱ�ȭ�ϴ� ������ ����
	//�����Ϸ����� �⺻ �����ڴ� �ڵ����� ��������.
	public InstanceMain04() {
		
	}
	
	public static void main(String[] args) {
		InstanceMain04 in = new InstanceMain04();
		in.num=5;
		//in.MAX_NUM = 1; -> ����� ���� �Ұ���
		
		System.out.println(in.num + "," + in.MAX_NUM);
		
		//����޼ҵ忡 ���� �����ϰ� ������� ��ȯ ����
		int result = in.multi(5, 7);
		System.out.println("result = "+result);
	} 
}
