package com.enumex.s01;

enum Item{
	ADD(5), DEL(11), SEARCH(2), CANCEL(22);
	
	//���� ������ ��������� �����ϱ� ���� ����
	private final int var;
	
	//������
	Item(int v){
		var = v;
	}
	
	public int getVar() {
		return var;
	}
}

public class EnumMain03 {
	public static void main(String[] args) {
		//values() �޼ҵ�� ���� Ÿ���� ��� ���� ��ü���� �迭�� ����� ��ȯ
		Item[] items = Item.values();
		
		for(Item n : items) {
			System.out.println(n + " : " + n.ordinal()+ " : " + n.getVar());
		}
		
		System.out.println("-----------------");

		
	}
}
