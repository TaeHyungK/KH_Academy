package com.inner.s01;

public class LocalMain01 {
	public void innerTest() {
		class Inner {
			public void getData() {
				System.out.println("Local 내부 클래스");
			}
		}
		Inner i = new Inner();
		i.getData();
	}

	public static void main(String[] args) {
		LocalMain01 m = new LocalMain01();
		m.innerTest();
	}
}
