package com.lang.s01;

class Car{
	String name;
	public Car(String name) {
		this.name = name;
	}
	
	//Object의 toString 재정의
	@Override
	public String toString() {
		return name;
	}
}

public class ObjectMain02 {
	public static void main(String[] args) {
		Car car = new Car("소나타");
		System.out.println(car.toString());
		System.out.println(car);
	}
}
