package com.enumex.s01;

enum Item{
	ADD(5), DEL(11), SEARCH(2), CANCEL(22);
	
	//위에 지정한 상수값들을 저장하기 위한 공간
	private final int var;
	
	//생성자
	Item(int v){
		var = v;
	}
	
	public int getVar() {
		return var;
	}
}

public class EnumMain03 {
	public static void main(String[] args) {
		//values() 메소드는 열거 타입의 모든 열거 객체들을 배열로 만들어 반환
		Item[] items = Item.values();
		
		for(Item n : items) {
			System.out.println(n + " : " + n.ordinal()+ " : " + n.getVar());
		}
		
		System.out.println("-----------------");

		
	}
}
