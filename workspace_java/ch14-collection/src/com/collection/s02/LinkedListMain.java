package com.collection.s02;

import java.util.LinkedList;

public class LinkedListMain {
	public static void main(String[] args) {
		String[] array = {"진달래", "백합", "개나리", "벚꽃", "장미"};
		
		//큐(Queue): 선입선출 (FIFO, First In First Out) 방식
		LinkedList<String> list = new LinkedList<String>();
		
		for(int i=0;i<array.length;i++) {
			list.offer(array[i]);
		}
		
		//저장된 요소의 목록
		System.out.println(list);
		System.out.println("-----------");
		
		while(list.peek() != null) { //데이터 검증
			//데이터를 반환하고 반환한 데이터 삭제
			System.out.println(list.poll());
		}
		
		System.out.println("-----------");
		System.out.println(list);
		
		
	}
}