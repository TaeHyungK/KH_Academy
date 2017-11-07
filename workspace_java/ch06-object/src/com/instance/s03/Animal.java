package com.instance.s03;

public class Animal {
	//은닉화
	private String name; //이름
	private int age; //나이
	private boolean fly; //비행 여부
//	private String fly_state;
	
	//인자가 없는 생성자
	public Animal() {}
	//인자가 있는 생성자
	public Animal(String n, int a, boolean f) {
		name = n;
		age = a;
		fly = f;
	}
	
	//캡슐화
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int a) {
		age = a;
	}
	
	public boolean isFly() {
		return fly;
	}
	public void setFly(boolean f) {
		fly = f;
//		if(fly == true)
//			fly_state = "가능";
//		else 
//			fly_state = "불가능";
	}
//	public String getFlyState() {
//		return fly_state;
//	}
	
	
	
}
