package com.extention.s03;

class People{
	
	//Method overriding(�Լ� ������)
	@Override//������̼��� ������ ������ �°� �����ǰ� �Ǿ����� ��������.
	public String toString() {
		return "People";
	}
}

class Animal{
	
}
public class OverridingMain03 {
	public static void main(String[] args) {
		People p = new People();
		System.out.println(p.toString());
		Animal a = new Animal();
		System.out.println(a.toString());
		
	}
}
