package com.inner.s02;

class Inner5{
	public void disp() {
		System.out.println("Inner7¿« disp");
	}
}

public class AnonyMain02 {
	
	public void innerTest() {
		class Inner extends Inner5{
			@Override
			public void disp() {
				System.out.println("Inner¿« disp");
			}
		}
		
		Inner i = new Inner();
		i.disp();
	}
	
	public static void main(String[] args) {
		AnonyMain02 am = new AnonyMain02();
		am.innerTest();
	}
}
