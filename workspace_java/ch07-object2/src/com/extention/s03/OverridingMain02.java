package com.extention.s03;

class Mother{
	public String getLunch() {
		return "��";
	}
}

class Son extends Mother {
	
}
class Daughter extends Mother{
	//Method Overriding(�Լ� ������)
	public String getLunch() {
		return "��";
	}
}
public class OverridingMain02 {
	public static void main(String[] args) {
		Son s = new Son();
		System.out.println("�Ƶ��� " + s.getLunch() + "�� �Դ´�.");
		Daughter d = new Daughter();
		System.out.println("���� " + d.getLunch() + "�� �Դ´�.");
		
	}
}
