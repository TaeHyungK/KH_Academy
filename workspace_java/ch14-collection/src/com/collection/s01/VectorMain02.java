package com.collection.s01;

import java.util.Vector;

public class VectorMain02 {
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>();
		
		v.add(new Double(100.3));
		v.add(3.14);
		v.add(1000.);//=1000.0
		
		//Ȯ�� for���� �̿��� ���
		for(Double d : v) {
			System.out.println(d);
		}
		System.out.println("-------");
		
		//��� �˻�
		double search = 1000.0; //�˻��� ���
		int index = v.indexOf(search);
		if(index != -1) {
			System.out.println("�˻���� " + search +"�� ��ġ: "+ index);
		}else {
			System.out.println("�˻���� " + search + "�� �����ϴ�.");
		}
		System.out.println("-------");
		
		//����� ����
		double del = 3.14;//������ ���
		if(v.contains(del)) {
			v.remove(del);
			System.out.println(del+" ���� �Ϸ�!");
		}
		
	}
}
