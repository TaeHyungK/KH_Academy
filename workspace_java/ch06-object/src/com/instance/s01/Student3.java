package com.instance.s01;

public class Student3 {
	//멤버 필드
	String name;
	int kor;
	int math;
	int eng;
	
	public int getSum() {
		return kor+math+eng;
	}
	
	public double getAvg() {
		return getSum()/3.0;
	}
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		Student3 student = new Student3();
		student.name="홍길동";
		student.kor=98;
		student.math=97;
		student.eng=95;
		
		//출력
		System.out.println("이름: " + student.name);		
		System.out.println("국어: " + student.kor);		
		System.out.println("수학: " + student.math);		
		System.out.println("영어: " + student.eng);		
		System.out.println("총점: " + student.getSum());
		System.out.printf("평균: %.2f", student.getAvg());
	}
}
