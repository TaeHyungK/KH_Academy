package com.instance.s03;

public class Animal {
	//����ȭ
	private String name; //�̸�
	private int age; //����
	private boolean fly; //���� ����
//	private String fly_state;
	
	//���ڰ� ���� ������
	public Animal() {}
	//���ڰ� �ִ� ������
	public Animal(String n, int a, boolean f) {
		name = n;
		age = a;
		fly = f;
	}
	
	//ĸ��ȭ
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
//			fly_state = "����";
//		else 
//			fly_state = "�Ұ���";
	}
//	public String getFlyState() {
//		return fly_state;
//	}
	
	
	
}
