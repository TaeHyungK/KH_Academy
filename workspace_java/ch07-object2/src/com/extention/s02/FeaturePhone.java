package com.extention.s02;

public class FeaturePhone extends Phone{
	private int pixel; // ���� ȭ�Ҽ�
	
	public FeaturePhone(String model, String number, String color, int pixel) {
		this.model = model;
		this.number = number;
		this.color = color;
		this.pixel = pixel;
	}
	
	public int getPixel() {
		return pixel;
	}
}
