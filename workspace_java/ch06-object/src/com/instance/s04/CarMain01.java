package com.instance.s04;

import javax.naming.Context;

class Car {
	String color; // ����
	String gearType; // ���ӱ� ����
	int door; // ���� ����

	//�⺻ ������(���� ����)
	//���ڰ� �ִ� ������ �ۼ��� �ݵ�� ����ؾ� ��!
	public Car() {
	}
	//���ڰ� �ִ� ������
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
		//��������� �ʱ�ȭ�� ������ ���
		System.out.println("c1�� color = " + c1.color);
		System.out.println("c1�� gearType = " + c1.gearType);
		System.out.println("c1�� door = " + c1.door);
		
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;
		System.out.println("--------�ʱ�ȭ ��--------");
		System.out.println("c1�� color = " + c1.color);
		System.out.println("c1�� gearType = " + c1.gearType);
		System.out.println("c1�� door = " + c1.door);

		System.out.println("----------------------");
		System.out.println("c2�� color = " + c2.color);
		System.out.println("c2�� gearType = " + c2.gearType);
		System.out.println("c2�� door = " + c2.door);
	}
}
