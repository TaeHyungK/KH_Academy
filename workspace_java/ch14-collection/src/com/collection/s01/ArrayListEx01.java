package com.collection.s01;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx01 {
	public static void main(String[] args) {
		
		//[실습]
		//(1~45) 중복되지 않은 6개의 숫자
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//반복문은 while문 사용
		//ArrayList 길이는 size() 메소드 사용
		//중복여부 contains() 메소드 사용 -> 중복되면 true 중복안되면 false
		
		while(list.size()<6) {
			int r = (int)(Math.random()*45+1);
			if(!list.contains(r)) {
				list.add(r);
			}
		}
		
		//정렬
		//오름차순
		Collections.sort(list);
		//내림차순(오름차순 정렬 후 사용해야됨)
//		Collections.reverse(list);
		
		System.out.println(list);
		
	}
}
