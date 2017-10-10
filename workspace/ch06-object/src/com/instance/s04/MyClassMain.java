package com.instance.s04;

public class MyClassMain {
	int a;
	int b;
	
	public MyClassMain(int n,int m) {
		//생성자는 객체가 생성될 때 멤버변수를 초기화 하는 역할을 하지만
		//그 외에 제어문을 사용해서 조건을 체크하거나 반복문을 이용한 작업을
		//수행할 수도 있고 특정 메소드를 호출할 수도 있음
		
		//멤버변수 초기화
		a = n;
		b = m;
		
		//데이터 출력
		if(n>0) {
			System.out.println(n+"은 양수 입니다.");
		}else {
			System.out.println(n+"은 양수가 아닙니다.");
		}
		
		if(m>0) {
			System.out.println(m+"은 양수 입니다.");
		}else {
			System.out.println(m+"은 양수가 아닙니다.");
		}
		
	}
	
	public static void main(String[] args) {
		MyClassMain mc = new MyClassMain(-10, 20);
	}
}
