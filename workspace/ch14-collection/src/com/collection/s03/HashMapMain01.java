package com.collection.s03;

import java.util.HashMap;

public class HashMapMain01 {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		//		key			value
		hm.put("������", new Integer(95));
		hm.put("õ����", new Integer(100));
		hm.put("������", new Integer(85));
		hm.put("���ְ�", new Integer(93));
		hm.put("�����", new Integer(70));
		
		//key�� �ߺ��Ǹ� ���߿� �Է��� ������ ��ü
		hm.put("õ����", new Integer(0));
		//HashMap�� value�� null�� ���
		hm.put("��ȣ��", null);
		//key���� null�� ���
		hm.put(null, new Integer(100));
		
		//����� key, value�� ��� Ȯ��
		System.out.println(hm);
		System.out.println("-----------------");
		
		Integer num = hm.get("õ����");
		System.out.println("õ������ ������? " + num);
		
		//��� ����, �Է� ������ ����������?
		
	}
}
