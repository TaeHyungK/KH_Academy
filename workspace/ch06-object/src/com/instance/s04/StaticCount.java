package com.instance.s04;

public class StaticCount {
	//�ν��Ͻ� ���� : ��ü�� �����Ǹ� ����μ� ����
	int c;
	//static(Ŭ����) ����: ȣ��� ��ü�� ���Ե��� �ʰ� static ������ ������
	static int count;
	
	public StaticCount() {
		c++;
		count++;
	}
}
