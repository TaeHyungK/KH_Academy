package com.collection.s01;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain07 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList();

		list.add("�ӷ�");//0
		list.add("���");//1
		list.add("�޵�");//2
		list.add("�ڵ�");//3
		list.add("���");//4
		
		//�ε��� Ž��
		int index1 = list.indexOf("���");
		int index2 = list.lastIndexOf("���");
		int index3 = list.indexOf("����");

		System.out.println("ù��° ��� : " + index1);
		System.out.println("�ι�° ��� : " + index2);
		System.out.println("���� : " + index3); // ���� �� ã���� -1
		
		//����
		Collections.sort(list);
		
		//����� ������ ��� ��ȸ
		System.out.println(list);
		
		//�������� ����
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
	}
}
