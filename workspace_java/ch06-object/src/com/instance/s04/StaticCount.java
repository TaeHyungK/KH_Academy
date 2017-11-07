package com.instance.s04;

public class StaticCount {
	//인스턴스 변수 : 객체가 생성되면 멤버로서 포함
	int c;
	//static(클래스) 변수: 호출시 객체에 포함되지 않고 static 영역에 생성됨
	static int count;
	
	public StaticCount() {
		c++;
		count++;
	}
}
