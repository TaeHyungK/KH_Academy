package com.instance.s02;

public class MethodMain03 {
	
	//�޼ҵ� ȣ��� ������ �ּҰ� ����
	public void increase(int[] n) {
		for(int i=0;i<n.length;i++) {
			n[i]++;
		}
	}
	public static void main(String[] args) {
		//���� ȣ��
		
		int[] ref1 = {100,200,300};
		
		System.out.println("===������ ���� �� ====");
		for(int i=0;i<ref1.length;i++) {
			System.out.println("ref1["+i+"]: "+ref1[i]);
		}
		
		System.out.println("===������ ���� �� ====");
		MethodMain03 mt = new MethodMain03();
		//�޼ҵ��� ���ڿ� ��ü�� �ּҸ� ����
		for(int i=0;i<ref1.length;i++) {
			System.out.println("ref["+i+"]: " +ref1[i]);
		}
	}
}
