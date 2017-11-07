package com.instance.s04;

import javax.naming.Context;

class Car {
	String color; // 색상
	String gearType; // 변속기 종류
	int door; // 문의 개수

	//기본 생성자(생략 가능)
	//인자가 있는 생성자 작성시 반드시 명시해야 함!
	public Car() {
	}
	//인자가 있는 생성자
	public Car(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}

public class CarMain01 {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("black", "auto", 2);
		//멤버변수의 초기화된 데이터 출력
		System.out.println("c1의 color = " + c1.color);
		System.out.println("c1의 gearType = " + c1.gearType);
		System.out.println("c1의 door = " + c1.door);
		
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;
		System.out.println("--------초기화 후--------");
		System.out.println("c1의 color = " + c1.color);
		System.out.println("c1의 gearType = " + c1.gearType);
		System.out.println("c1의 door = " + c1.door);

		System.out.println("----------------------");
		System.out.println("c2의 color = " + c2.color);
		System.out.println("c2의 gearType = " + c2.gearType);
		System.out.println("c2의 door = " + c2.door);
	}
}
