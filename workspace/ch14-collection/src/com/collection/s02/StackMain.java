package com.collection.s02;

import java.util.Stack;

public class StackMain {
	public static void main(String[] args) {
		String[] array = {"진달래", "백합", "개나리", "벚꽃", "장미"};
		
		//stack : 후입선출(LIFO, Last In First Out) 방식
		Stack<String> stk = new Stack<String>();
		
		for(int i=0;i<array.length;i++) {
			stk.push(array[i]);//요소의 저장
		}
		//저장된 데이터의 목록
		System.out.println(stk);
		System.out.println("----------------------------");
		
		while(!stk.isEmpty()) {
			//현재 스택이 비어있지 않다면
			
			//스택에 저장된 객체(스택의 가자 위에있는 객체, Top)를 꺼내와서 출력
			System.out.println(stk.pop());
		}
		System.out.println("--------------------");
		System.out.println(stk);
		
	}
}
