package com.extention.s03;

//부모 클래스
class GrandParent{
	public String getCar() {
		return "구형 자동차";
	}
}
//자식 클래스
class Father extends GrandParent{
	//Method Overriding
	public String getCar() {
		return "신형 자동차";
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
