package com.collection.s03;

import java.util.HashMap;

public class HashMapMain01 {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		//		key			value
		hm.put("도민준", new Integer(95));
		hm.put("천송이", new Integer(100));
		hm.put("유세미", new Integer(85));
		hm.put("이휘경", new Integer(93));
		hm.put("이재경", new Integer(70));
		
		//key가 중복되면 나중에 입력한 값으로 대체
		hm.put("천송이", new Integer(0));
		//HashMap은 value에 null을 허용
		hm.put("강호동", null);
		//key에도 null을 허용
		hm.put(null, new Integer(100));
		
		//저장된 key, value의 목록 확인
		System.out.println(hm);
		System.out.println("-----------------");
		
		Integer num = hm.get("천송이");
		System.out.println("천송이의 성적은? " + num);
		
		//출력 순서, 입력 순서는 무작위인지?
		
	}
}
