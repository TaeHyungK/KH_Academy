package com.lang.s01;
class Value{
	int value;
	
	public Value(int value) {
		this.value = value;
	}
}
public class ObjectMain03 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(20);
		
		//참조값을 이용한 객체 비교
		System.out.println(v1);
		System.out.println(v2);
		System.out.println("-----------");
		
		//Object의 equals 메소드를 이용한 객체비교
		if(v1.equals(v2)) {
			System.out.println("v1과 v2는 같은 객체");
		}else {
			System.out.println("v1과 v2는 다른 객체");
		}
		System.out.println("-----------");
		
		//객체비교(v1.equals(v2)와 동일한 결과)
		if(v1 == v2){
			System.out.println("v1과 v2는 같은 객체");
		}else {
			System.out.println("v1과 v2는 다른 객체");
		}
		System.out.println("-----------");
		
	}
}
