package com.instance.s02;

public class MethodMain04 {
	
/*	public void argTest(int a) {
		
	}
	
	public void argTest2(int a,int b) {
		
	}

	public void argTest2(int a,int b,int c) {
		
	}
*/	
	//... <- ���� ����(Variable Arguments)
	/*
	 * JDK5.0�̻���� ��� ����
	 * �ڷ����� ��ġ�� �� �����ϰ��� �ϴ� ���� ������ �ٸ��� ������ �� ����.
	 * ���޵Ǵ� �����ʹ� ���������� �迭�� �ν���
	 * tip) int[]�� int ... : int[]�� �������� int ... �� ��������
	 */
	public void argTest(int ... a) {
		for(int i=0;i<a.length;i++) {
			System.out.println("a["+i+"]: " + a[i]);
		}
		System.out.println("--------------");
	}
	public static void main(String[] args) {
		System.out.println("===��������===");
		
		MethodMain04 mt = new MethodMain04();
		mt.argTest();
		mt.argTest(1,2);
		mt.argTest(10,20,30,40);
	}
}
