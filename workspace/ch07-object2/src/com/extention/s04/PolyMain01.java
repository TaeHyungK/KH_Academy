package com.extention.s04;

class Parent{
	int a= 100;
}

class Child extends Parent{
	int b= 200;
}

public class PolyMain01 {
	public static void main(String[] args) {
		//객체는 상속 관계간에 형변환 가능
		Child ch = new Child();
		System.out.println(ch.a);
		System.out.println(ch.b);
		System.out.println("--------------");
		
		//자식클래스 타입 -> 부모클래스 타입 형변환
		//업캐스팅, 자동적으로 형변환
		Parent p = ch;
		System.out.println(p.a);
		System.out.println("--------------");
		//호출 범위를 벗어나 호출 불가
//		System.out.println(p.b);
		
		//부모클래스 타입 -> 자식클래스타입 형변환
		//다운캐스팅, "명시적"으로 형변환
		Child ch2 = (Child) p;
		System.out.println(ch2.a);
		System.out.println(ch2.b);
		
		
	}
}
