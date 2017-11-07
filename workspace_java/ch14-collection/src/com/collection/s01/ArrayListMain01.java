package com.collection.s01;

import java.util.ArrayList;

class A{
	@Override
	public String toString() {
		return "A";
	}
}
class B{}

public class ArrayListMain01 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new A());//A->Object
		list.add(new B());//B->Object
		list.add(new String("박명수"));//String->Object
		list.add(new Integer(100));//Integer->Object
		
		//저장된 객체의 목록
		System.out.println(list);
		//요소의 개수
		System.out.println(list.size());
		
		
	}
}
