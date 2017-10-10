package com.instance.s01;

public class Student2 {
	//¸â¹ö ÇÊµå
	String name;
	int kor;
	int math;
	int eng;
	int sum;
	double avg;
	
	public static void main(String[] args) {
		//°´Ã¼ ¼±¾ğ ¹× »ı¼º
		Student2 student = new Student2();
		
		student.name = "È«±æµ¿";
		student.kor= 98;
		student.math= 97;
		student.eng= 95;
		student.sum= student.kor + student.math + student.eng;
		student.avg= student.sum/3.0;
		
		System.out.println("ÀÌ¸§: " + student.name);		
		System.out.println("±¹¾î: " + student.kor);		
		System.out.println("¼öÇĞ: " + student.math);		
		System.out.println("¿µ¾î: " + student.eng);		
		System.out.println("ÃÑÁ¡: " + student.sum);
		System.out.printf("Æò±Õ: %.2f", student.avg);
	}
	
}
