package com.lang.s01;
class Value{
	int value;
	
	public Value(int value) {
		this.value = value;
	}
}
public class ObjectMain03 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(20);
		
		//�������� �̿��� ��ü ��
		System.out.println(v1);
		System.out.println(v2);
		System.out.println("-----------");
		
		//Object�� equals �޼ҵ带 �̿��� ��ü��
		if(v1.equals(v2)) {
			System.out.println("v1�� v2�� ���� ��ü");
		}else {
			System.out.println("v1�� v2�� �ٸ� ��ü");
		}
		System.out.println("-----------");
		
		//��ü��(v1.equals(v2)�� ������ ���)
		if(v1 == v2){
			System.out.println("v1�� v2�� ���� ��ü");
		}else {
			System.out.println("v1�� v2�� �ٸ� ��ü");
		}
		System.out.println("-----------");
		
	}
}
