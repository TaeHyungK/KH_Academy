package com.extention.s02;

public class SmartPhone extends Phone {
	private String os;
	
	public SmartPhone(String model, String number, String color, String os) {
		this.model = model;
		this.number = number;
		this.color = color;
		this.os = os;
	}
	
	public String getOs() {
		return os;
	}
}
