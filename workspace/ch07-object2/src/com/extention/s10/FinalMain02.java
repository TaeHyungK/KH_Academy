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
	
	//�޼ҵ忡 final������ �ڽ�Ŭ�������� �޼ҵ� �������̵� �Ұ�
//	@Override
//	public void setVar(int var) {
//		System.out.println(var);
//	}
}
