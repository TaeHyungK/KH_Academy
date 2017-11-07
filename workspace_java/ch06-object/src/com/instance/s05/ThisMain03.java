package com.instance.s05;

public class ThisMain03 {
	
	//this() : 생성자 내부에서 또 다른 생성자를 호출할 때 사용
	public ThisMain03() {
//		System.out.println("~~~~"); -> this()는 항상 맨 위에 있어야 함
		this("바람");
	}
	public ThisMain03(String msg) {
		System.out.println(msg);
	}
	public ThisMain03(int a) {
		this(String.valueOf(a));
//		this(Integer.toString(a));
	}
	
	public static void main(String[] args) {
		ThisMain03 tm1 = new ThisMain03();
		ThisMain03 tm2 = new ThisMain03("가을 여행");
		ThisMain03 tm3 = new ThisMain03(1241);
		
		
	}
}
