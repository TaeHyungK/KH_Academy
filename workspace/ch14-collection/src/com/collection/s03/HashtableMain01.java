package com.collection.s03;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableMain01 {
	public static void main(String[] args) {
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		h.put("김신", "서울");
		h.put("지은탁", "서울");
		h.put("저승사자", "광주");
		h.put("써니", "부산");
		h.put("유덕화", "인천");
		//key가 중복되면 마지막에 입력한 값으로 대체
		h.put("김신", "몬트리올");
		//key, vlaue에 null 불허
//		h.put(null, "제주도");
//		h.put("귀신1", null);
		
		System.out.println(h);
		System.out.println("-------------------------------");
		
		//반복문을 이용한 key, value 출력
		Enumeration<String> en = h.keys();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println(key + " : " +  h.get(key));
		}
		
	}
}
