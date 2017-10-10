package com.iostream.s06;

import java.io.Serializable;

/*
 * Serializable 인터페이스를 구현하면 해당 클래스는 객체 직렬화 대상이 되어
 * 언제든지 객체직렬화를 수행할 수 있음.
 * Serializable이 구현디지 않으면 객체 직렬화 불가능
 * 멤버 변수가 직렬화의 대상
 */
public class Customer implements Serializable{
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
