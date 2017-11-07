package com.collection.s01;

import java.util.ArrayList;

public class ArrayListMain04 {
	public static void main(String[] args) {
		ArrayList<String> list =  new ArrayList<String>();
		list.add("강호동");//index: 0
		list.add("유재석");//		   1
		list.add("김병만");//		   2
		list.add("박명수");//		   3
		
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i+" : "+name);
		}
		System.out.println("------------");
		
		//요소의 삭제
		list.remove(2);//인덱스
		
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i+" : "+name);
		}
		System.out.println("------------");
		
		//요소의 삭제
		list.remove("강호동");//요소
		
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i+" : "+name);
		}
		System.out.println("------------");
		
	}
}
