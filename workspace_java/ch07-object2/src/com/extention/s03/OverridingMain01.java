package com.extention.s03;

//�θ� Ŭ����
class GrandParent{
	public String getCar() {
		return "���� �ڵ���";
	}
}
//�ڽ� Ŭ����
class Father extends GrandParent{
	//Method Overriding
	public String getCar() {
		return "���� �ڵ���";
	}
}

class Uncle extends GrandParent{
	
}
public class OverridingMain01 {
	public static void main(String[] args) {
		Father ft = new Father();
		System.out.println(ft.getCar());
		
		Uncle uc = new Uncle();
		System.out.println(uc.getCar());
	}
}
