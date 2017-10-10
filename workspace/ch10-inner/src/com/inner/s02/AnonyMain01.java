package com.inner.s02;

class Inner6{
	public void disp() {
		System.out.println("Inner6�� disp");
	}
}

class AnonyEx{
	int a= 100;
	//��� ���� Ŭ����
	class Inner extends Inner6{
		@Override
		public void disp() {
			System.out.println("Inner�� disp");
		}
	}
}

public class AnonyMain01 {

	public static void main(String[] args) {
		AnonyEx ae = new AnonyEx();
		AnonyEx.Inner in = ae.new Inner();
		in.disp();
	}

}
