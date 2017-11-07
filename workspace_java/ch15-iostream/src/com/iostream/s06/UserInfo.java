package com.iostream.s06;

import java.io.Serializable;

public class UserInfo implements Serializable{

	private String name;
	private int age;
	private String addr;
	
	public UserInfo(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age + ", 주소: " + addr;
	}
	
	
	
}
