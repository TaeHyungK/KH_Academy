package com.collection.s01;

import java.util.Vector;

public class VectorMain01 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		//��� �߰�
		v.add("�迬��");//0
		v.add("��̶�");//1
		v.add("�տ���");//2
		v.add("�̻�ȭ");//3
		
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		System.out.println("---------");
		
		for(String s : v) {
			System.out.println(s);
		}
	}
}
