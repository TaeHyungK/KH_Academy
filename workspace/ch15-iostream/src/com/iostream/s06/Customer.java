package com.iostream.s06;

import java.io.Serializable;

/*
 * Serializable �������̽��� �����ϸ� �ش� Ŭ������ ��ü ����ȭ ����� �Ǿ�
 * �������� ��ü����ȭ�� ������ �� ����.
 * Serializable�� �������� ������ ��ü ����ȭ �Ұ���
 * ��� ������ ����ȭ�� ���
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
