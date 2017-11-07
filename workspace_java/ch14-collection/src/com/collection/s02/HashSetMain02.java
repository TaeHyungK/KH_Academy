package com.collection.s02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HashSetMain02 {
	public static void main(String[] args) {
		//�ζ�
		//(1~45)�ߺ����� ���� 6���� ����
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		while(hs.size() < 6) {
			int r = (int)(Math.random()*45+1);
			
			hs.add(r);
		}
		
		//����
//		Collections.sort(hs); Ÿ�� ����ġ�� �Ұ�

		//Set -> List ��ȯ �� �����ؾ� ��
		ArrayList<Integer> list = new ArrayList<Integer>(hs);
		Collections.sort(list);
		
		
		for(int s : hs) {
			System.out.print(s +"\t");
		}
	}
}
