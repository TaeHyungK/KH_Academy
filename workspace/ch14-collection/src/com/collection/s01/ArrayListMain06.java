package com.collection.s01;

import java.util.ArrayList;

public class ArrayListMain06 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);//0
		list.add(20);//1
		list.add(15);//2
		list.add(16);//3
		
		System.out.println(list);
		
		//반복문을 이용하고 조건체크해서 짝수는 삭제
		//list는 삭제시 뒤에서부터!! ★ 앞에서부터 하면 인덱스 변경으로 값 누락됨
		for(int i=list.size()-1; i>=0 ;i--) {
			System.out.println(list.get(i));
			if(list.get(i)%2 == 0) {
				list.remove(i);

			}
		}
		
		System.out.println(list);
		
		
	}
}
