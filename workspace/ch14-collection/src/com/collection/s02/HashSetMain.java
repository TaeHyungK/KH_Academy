package com.collection.s02;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain {
	public static void main(String[] args) {
		String[] array = {"Java","JSP","Java","Android"};
		
		//HashSet : 중복값 불허
		HashSet<String> hs=  new HashSet<String>();
		for(String n : array) {
			//요소의 저장
			hs.add(n);//add() 메소드에서 중복을 불허함
		}
		//저장된 데이터 목록
		System.out.println(hs);
		
		//요소의 출력
		Iterator<String> ir = hs.iterator();
		while(ir.hasNext()) {//데이터 검증
			//데이터 반환
			System.out.println(ir.next());
		}
		
		System.out.println("----------");
		for(String s : hs) {
			System.out.println(s);
		}
		
	}
}
