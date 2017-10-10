package com.collection.s01;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class VectorMain03 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(12);
		v.add(39);
		v.add(8);
		v.add(10);
		
		System.out.println(v);
		
		//최대값
		Integer i = Collections.max(v);
		System.out.println("최대값: " + i);
		//최소값
		i = Collections.min(v);
		System.out.println("최소값: " + i);
		
	}
}
