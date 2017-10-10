package com.collection.s01;

import java.util.ArrayList;

public class ArrayListMain05 {
	public static void main(String[] args) {
		ArrayList<Integer>list = new ArrayList<Integer>();

		list.add(new Integer(10));
		list.add(new Integer(2));
		list.add(30); //int -> Integer 오토박싱
		list.add(40); //int -> Integer 오토박싱
		
		for(int i=0;i<list.size();i++) {
			Integer num = list.get(i);
			System.out.println(i+" : "+num);
		}
		System.out.println("----------");
		
		//요소 삭제
		list.remove(2); // 인덱스
		
		for(int i=0;i<list.size();i++) {
			Integer num = list.get(i);
			System.out.println(i+" : "+num);
		}
		System.out.println("----------");
	
		//요소 삭제
		list.remove(new Integer(2)); //요소
		
		for(int i=0;i<list.size();i++) {
			Integer num = list.get(i);
			System.out.println(i+" : "+num);
		}
		System.out.println("----------");
	}
}
