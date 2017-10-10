package com.inner.s02;

class Inner7 {
	public void disp() {
		System.out.println("Inner7의 disp");
	}
}

public class AnonyMain03 {

	public void innerTest() {
		//익명 내부 클래스
		//생성자 뒤에 ★중괄호★가 있으면 익명 내부클래스를 이용한 익명 객체를 생성한 것!!
		//익명내부클래스는 클래스명이 없기 때문에 부모클래스 타입을 사용하게 되므로
		//재정의된 메소드만 호출 가능
		Inner7 i = new Inner7(){
			//부모클래스의 메소드 재정의
			@Override
			public void disp() {
				System.out.println("익명객체의 disp");
			}
			public void make() {
				System.out.println("make 메소드");
			}
		};
		
		i.disp();
		//호출 범위를 벗어나서 호출 불가
//		i.make();
		
	}

	public static void main(String[] args) {
		AnonyMain03 am = new AnonyMain03();
		am.innerTest();
	}
}
