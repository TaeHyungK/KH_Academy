package com.inner.s01;

public class LocalMain02 {
	int a = 100; // 멤버변수
	
	public void innerTest() {
		//JDK7.0이하에서는 지역변수를 내부클래스에서 호출할 수 없기 때문에
		//final을 명시해 상수화해야 함
		
		int b = 200; // 지역변수
		
		//로컬 내부클래스
		class Inner{
			int c = 300; // 내부클래스의 멤버변수
			public void getData() {
				//로컬내부클래스에서 지역변수를 호출할 때는 JDK8.0부터 자동으로
				//상수화 시키기 때문에 값을 변경할 수 없음
//				b= 400;
				
				System.out.println("a: " + a);
				System.out.println("b: " + b);
				System.out.println("c: " + c);
			}
		}
		
		Inner i = new Inner();
		i.getData();
	}
	
	public static void main(String[] args) {
		LocalMain02 m = new LocalMain02();
		m.innerTest();
	}
}
