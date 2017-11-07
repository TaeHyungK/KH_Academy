package com.collection.s01;

import java.util.ArrayList;

class CartItem{
	String code; //��ǰ�ڵ�
	int num; //����
	int price; //�ܰ�
	
	public CartItem(String code, int num, int price) {
		this.code = code;
		this.num = num;
		this.price = price;
	}
	
}

public class ArrayListMain08 {
	public static void main(String[] args) {
		//2���� �迭 ���¸� ArrayList�� �����ϱ�
		ArrayList<CartItem> list = new ArrayList<CartItem>();

		list.add(new CartItem("A1001", 2, 2000));
		list.add(new CartItem("A1002", 10, 5000));
		list.add(new CartItem("A1003", 5, 1000));
				
		System.out.printf("%s %8s %8s\n", "��ǰ�ڵ�", "����", "����");
		System.out.println("-----------------------");
		
		for(CartItem item : list) {
			System.out.printf("%s %8s %8s\n", item.code, item.num, item.price);
		}
	}
}
