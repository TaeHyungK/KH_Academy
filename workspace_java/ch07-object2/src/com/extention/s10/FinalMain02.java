package com.extention.s10;

class Me{
	int var =200;
	
	public final void setVar(int var) {
		this.var = var;
	}
}

public class FinalMain02 extends Me{
	public static void main(String[] args) {
		FinalMain02 fm = new FinalMain02();
		fm.setVar(100);
		System.out.println(fm.var);
		
	}
	
	//메소드에 final지정시 자식클래스에서 메소드 오버라이드 불가
//	@Override
//	public void setVar(int var) {
//		System.out.println(var);
//	}
}
