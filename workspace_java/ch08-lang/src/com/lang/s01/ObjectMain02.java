package com.lang.s01;

class Car{
	String name;
	public Car(String name) {
		this.name = name;
	}
	
	//Object�� toString ������
	@Override
	public String toString() {
		return name;
	}
}

public class ObjectMain02 {
	public static void main(String[] args) {
		Car car = new Car("�ҳ�Ÿ");
		System.out.println(car.toString());
		System.out.println(car);
	}
}
