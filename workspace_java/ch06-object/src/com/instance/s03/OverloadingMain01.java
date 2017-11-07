package com.instance.s03;

public class OverloadingMain01 {
	//메소드 오버로딩(method Overloading, 중복정의)
	//메소드의 이름은 같고 전달되는 인자의 타입, 개수, 순서 등을 다르게
	//명시함으로써 메소드가 충돌되지 않고 호출되는 방식
	//메소드의 기능이 같으면 같은 메소드명을 사용함으로써 메소드의 사용을
	//효율적으로 할 수 있다.
	
	
	public void print(int n) {
		System.out.println("정수 n= " + n);
	}
	public void print(double n) {
		System.out.println("실수 n= " + n);
	}
	public void print(double n, long a) {
		System.out.println("실수 n= "+n +", " + "정수 a= " +a);
	}
	public void print(long a, double n) {
		System.out.println("정수 a= "+a+", "+"실수 n= "+n);
	}
	
	public static void main(String[] args) {
		OverloadingMain01 ot = new OverloadingMain01();
		
		ot.print(3);
		ot.print(3.0);
		ot.print(3.2, 237509235L);
		ot.print(59803L,1.8);
	}
}
