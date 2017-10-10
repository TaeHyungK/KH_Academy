package com.collection.s01;

import java.util.ArrayList;

public class ArrayListMain05 {
	public static void main(String[] args) {
		ArrayList<Integer>list = new ArrayList<Integer>();

		list.add(new Integer(10));
		list.add(new Integer(2));
		list.add(30); //int -> Integer ����ڽ�
		list.add(40); //int -> Integer ����ڽ�
		
		for(int i=0;i<list.size();i++) {
			Integer num = list.get(i);
			System.out.println(i+" : "+num);
		}
		System.out.println("----------");
		
		//��� ����
		list.remove(2); // �ε���
		
		for(int i=0;i<list.size();i++) {
			Integer num = list.get(i);
			System.out.println(i+" : "+num);
		}
		System.out.println("----------");
	
		//��� ����
		list.remove(new Integer(2)); //���
		
		for(int i=0;i<list.size();i++) {
			Integer num = list.get(i);
			System.out.println(i+" : "+num);
		}
		System.out.println("----------");
	}
}
