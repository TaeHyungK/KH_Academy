package com.collection.s01;

import java.util.Vector;

public class VectorMain02 {
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>();
		
		v.add(new Double(100.3));
		v.add(3.14);
		v.add(1000.);//=1000.0
		
		//확장 for문을 이용한 출력
		for(Double d : v) {
			System.out.println(d);
		}
		System.out.println("-------");
		
		//요소 검색
		double search = 1000.0; //검색할 요소
		int index = v.indexOf(search);
		if(index != -1) {
			System.out.println("검색요소 " + search +"의 위치: "+ index);
		}else {
			System.out.println("검색요소 " + search + "가 없습니다.");
		}
		System.out.println("-------");
		
		//요소의 삭제
		double del = 3.14;//삭제할 요소
		if(v.contains(del)) {
			v.remove(del);
			System.out.println(del+" 삭제 완료!");
		}
		
	}
}
