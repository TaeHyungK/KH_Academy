package com.extention.s04;

class A{
	public void make() {
		System.out.println("make 메소드");
	}
}
class B extends A{
	public void play() {
		System.out.println("play 메소드");
	}
}

public class PolyMain02 {
	public static void main(String[] args) {
		B bp = new B();
		bp.make();
		bp.play();
		
		//자식클래스 타입 -> 부모클래스 타입
		//업캐스팅, 자동 형변환
		A ap = bp;
		ap.make();
		//호출 범위를 벗어나 호출 불가능
//		ap.play();
		
		//부모클래스 타입 -> 자식클래스 타입
		//다운캐스팅, 명시적 형변환
		B bp2 = (B)ap;
		bp2.make();
		bp2.play();
		
	}
}
