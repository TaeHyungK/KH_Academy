package com.collection.s01;

import java.util.ArrayList;

public class ArrayListMain02 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add("��ȣ��");//String -> Object
		list.add("���缮");//String -> Object
		list.add("�躴��");//String -> Object
		list.add("����ȣ");//String -> Object
		
		//�ݺ����� �̿��� ���
		for(int i=0;i<list.size();i++) {
			//			Object->String
			//			�ٿ� ĳ����
			String name = list.get(i).toString();
			System.out.println(name);
		}
	}
}
