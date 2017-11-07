package com.collection.s03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class HashMapMain02 {
	public static void main(String[] args) {
		String[] city = {"Berlin", "Paris", "Seoul", "New York", "London"};
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		for(int i=0; i<city.length; i++) {
			map.put(i, city[i]);
		}
		System.out.println(map);
		System.out.println("-------------------");
		
//		Set<Integer> s = map.keySet();
//		Iterator<Integer> keys = s.iterator();
		
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(key + " : " + map.get(key));
		}
		
		//확장 for문 사용
		for(Integer key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
				
		
	}
}
