package com.collection.s01;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx01 {
	public static void main(String[] args) {
		
		//[�ǽ�]
		//(1~45) �ߺ����� ���� 6���� ����
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//�ݺ����� while�� ���
		//ArrayList ���̴� size() �޼ҵ� ���
		//�ߺ����� contains() �޼ҵ� ��� -> �ߺ��Ǹ� true �ߺ��ȵǸ� false
		
		while(list.size()<6) {
			int r = (int)(Math.random()*45+1);
			if(!list.contains(r)) {
				list.add(r);
			}
		}
		
		//����
		//��������
		Collections.sort(list);
		//��������(�������� ���� �� ����ؾߵ�)
//		Collections.reverse(list);
		
		System.out.println(list);
		
	}
}
