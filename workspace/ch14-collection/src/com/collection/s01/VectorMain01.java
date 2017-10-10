package com.collection.s01;

import java.util.Vector;

public class VectorMain01 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		//요소 추가
		v.add("김연아");//0
		v.add("장미란");//1
		v.add("손연재");//2
		v.add("이상화");//3
		
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		System.out.println("---------");
		
		for(String s : v) {
			System.out.println(s);
		}
	}
}
