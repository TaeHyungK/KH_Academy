package com.collection.s01;

import java.util.ArrayList;

public class ArrayListMain04 {
	public static void main(String[] args) {
		ArrayList<String> list =  new ArrayList<String>();
		list.add("��ȣ��");//index: 0
		list.add("���缮");//		   1
		list.add("�躴��");//		   2
		list.add("�ڸ��");//		   3
		
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i+" : "+name);
		}
		System.out.println("------------");
		
		//����� ����
		list.remove(2);//�ε���
		
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i+" : "+name);
		}
		System.out.println("------------");
		
		//����� ����
		list.remove("��ȣ��");//���
		
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i+" : "+name);
		}
		System.out.println("------------");
		
	}
}
