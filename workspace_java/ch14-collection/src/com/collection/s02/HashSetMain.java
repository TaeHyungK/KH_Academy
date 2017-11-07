package com.collection.s02;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain {
	public static void main(String[] args) {
		String[] array = {"Java","JSP","Java","Android"};
		
		//HashSet : �ߺ��� ����
		HashSet<String> hs=  new HashSet<String>();
		for(String n : array) {
			//����� ����
			hs.add(n);//add() �޼ҵ忡�� �ߺ��� ������
		}
		//����� ������ ���
		System.out.println(hs);
		
		//����� ���
		Iterator<String> ir = hs.iterator();
		while(ir.hasNext()) {//������ ����
			//������ ��ȯ
			System.out.println(ir.next());
		}
		
		System.out.println("----------");
		for(String s : hs) {
			System.out.println(s);
		}
		
	}
}
