package com.instance.s02;

public class MethodMain03 {
	
	//메소드 호출시 인자의 주소가 전달
	public void increase(int[] n) {
		for(int i=0;i<n.length;i++) {
			n[i]++;
		}
	}
	public static void main(String[] args) {
		//참조 호출
		
		int[] ref1 = {100,200,300};
		
		System.out.println("===데이터 번경 전 ====");
		for(int i=0;i<ref1.length;i++) {
			System.out.println("ref1["+i+"]: "+ref1[i]);
		}
		
		System.out.println("===데이터 번경 후 ====");
		MethodMain03 mt = new MethodMain03();
		//메소드의 인자에 객체의 주소를 전달
		for(int i=0;i<ref1.length;i++) {
			System.out.println("ref["+i+"]: " +ref1[i]);
		}
	}
}
