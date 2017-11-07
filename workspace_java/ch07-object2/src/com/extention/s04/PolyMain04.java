package com.extention.s04;

class Car{
	String color;
	int door;
	
	public void drive() {
		System.out.println("drive!!");
	}
	public void stop() {
		System.out.println("stop!!");
	}
	public void getPower() {
		System.out.println("보통 자동차!!");
	}
}

class FireEngine extends Car{
	
	public void water() {
		System.out.println("water!!");
	}
	@Override
	public void getPower() {
		System.out.println("소방설비를 갖춘 자동차!!");
	}
}


public class PolyMain04 {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		fe.drive();//Car의 drive()
		fe.stop();//Car의 stop()
		fe.water();//FireEngine의 water()
		fe.getPower();//FireEngine의 getPower()
		System.out.println("--------------------");
		
		//자식클래스 타입 -> 부모클래스 타입
		//업캐스팅, 자동 형변환
		Car c = fe;
		c.drive();
		c.stop();
		//호출 범위를 벗어나 호출 불가
//		c.water()
		c.getPower();//FireEngine의 getPower()를 호출함.
		
	}
}
