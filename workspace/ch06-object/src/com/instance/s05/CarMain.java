package com.instance.s05;
class Car{
	String color;
	String gearType;
	int door;
	
	public Car() {
		this("white","auto",4);
	}
	public Car(String color) {
		this(color,"auto",4);
	}
	public Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
public class CarMain {
	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println(car1.color + ", " + car1.gearType + ", " + car1.door);
		Car car2 = new Car("black");
		System.out.println(car2.color + ", " + car2.gearType + ", " + car2.door);
		Car car3 = new Car("blue", "manual", 5);
		System.out.println(car3.color + ", " + car3.gearType + ", " + car3.door);
	}
}
