package com.instance.s02;

public class MethodMain04 {
	
/*	public void argTest(int a) {
		
	}
	
	public void argTest2(int a,int b) {
		
	}

	public void argTest2(int a,int b,int c) {
		
	}
*/	
	//... <- 가변 인자(Variable Arguments)
	/*
	 * JDK5.0이상부터 사용 가능
	 * 자료형이 일치할 때 전달하고자 하는 값의 갯수를 다르게 지정할 수 있음.
	 * 전달되는 데이터는 내부적으로 배열로 인식함
	 * tip) int[]와 int ... : int[]은 고정길이 int ... 은 가변길이
	 */
	public void argTest(int ... a) {
		for(int i=0;i<a.length;i++) {
			System.out.println("a["+i+"]: " + a[i]);
		}
		System.out.println("--------------");
	}
	public static void main(String[] args) {
		System.out.println("===가변인자===");
		
		MethodMain04 mt = new MethodMain04();
		mt.argTest();
		mt.argTest(1,2);
		mt.argTest(10,20,30,40);
	}
}
