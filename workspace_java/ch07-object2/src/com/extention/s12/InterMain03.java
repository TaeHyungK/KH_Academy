package com.extention.s12;

interface InterTest{
	public static final int A = 100;
	
	public abstract int getNum();
}

class InterEx implements InterTest{

	@Override
	public int getNum() {
		return A;
	}
	
}
public class InterMain03 {
	public static void main(String[] args) {
		System.out.println(InterTest.A);
		
		InterEx it = new InterEx();
		System.out.println(it.getNum());
	}
}
