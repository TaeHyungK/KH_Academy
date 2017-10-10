package com.collection.s03;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableMain01 {
	public static void main(String[] args) {
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		h.put("���", "����");
		h.put("����Ź", "����");
		h.put("���»���", "����");
		h.put("���", "�λ�");
		h.put("����ȭ", "��õ");
		//key�� �ߺ��Ǹ� �������� �Է��� ������ ��ü
		h.put("���", "��Ʈ����");
		//key, vlaue�� null ����
//		h.put(null, "���ֵ�");
//		h.put("�ͽ�1", null);
		
		System.out.println(h);
		System.out.println("-------------------------------");
		
		//�ݺ����� �̿��� key, value ���
		Enumeration<String> en = h.keys();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println(key + " : " +  h.get(key));
		}
		
	}
}
