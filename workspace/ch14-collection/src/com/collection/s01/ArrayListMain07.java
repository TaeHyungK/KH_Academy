package com.collection.s01;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain07 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList();

		list.add("머루");//0
		list.add("사과");//1
		list.add("앵두");//2
		list.add("자두");//3
		list.add("사과");//4
		
		//인덱스 탐색
		int index1 = list.indexOf("사과");
		int index2 = list.lastIndexOf("사과");
		int index3 = list.indexOf("망고");

		System.out.println("첫번째 사과 : " + index1);
		System.out.println("두번째 사과 : " + index2);
		System.out.println("망고 : " + index3); // 없는 값 찾으면 -1
		
		//정렬
		Collections.sort(list);
		
		//저장된 데이터 목록 조회
		System.out.println(list);
		
		//역순으로 정렬
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
	}
}
