package com.collection.s02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HashSetMain02 {
	public static void main(String[] args) {
		//로또
		//(1~45)중복되지 않은 6개의 숫자
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		while(hs.size() < 6) {
			int r = (int)(Math.random()*45+1);
			
			hs.add(r);
		}
		
		//정렬
//		Collections.sort(hs); 타입 불일치로 불가

		//Set -> List 변환 후 정렬해야 함
		ArrayList<Integer> list = new ArrayList<Integer>(hs);
		Collections.sort(list);
		
		
		for(int s : hs) {
			System.out.print(s +"\t");
		}
	}
}
