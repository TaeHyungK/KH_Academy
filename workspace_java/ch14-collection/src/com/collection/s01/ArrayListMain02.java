package com.collection.s01;

import java.util.ArrayList;

public class ArrayListMain02 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add("강호동");//String -> Object
		list.add("유재석");//String -> Object
		list.add("김병만");//String -> Object
		list.add("김준호");//String -> Object
		
		//반복문을 이용한 출력
		for(int i=0;i<list.size();i++) {
			//			Object->String
			//			다운 캐스팅
			String name = list.get(i).toString();
			System.out.println(name);
		}
	}
}
