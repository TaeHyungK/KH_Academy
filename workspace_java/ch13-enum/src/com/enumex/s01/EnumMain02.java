package com.enumex.s01;

//JDK5.0�̻���� ��� ����
//������ ����� ������ �����Ǵ� ��ü
enum Lesson{
	JAVA,XML,JSP
}

public class EnumMain02 {
	public static void main(String[] args) {
		System.out.println(Lesson.JAVA);
		System.out.println(Lesson.XML);
		System.out.println(Lesson.JSP);
		System.out.println("--------");
		
		//���� ��ü�� ���ڿ� ��ȯ
		System.out.println(Lesson.JAVA.name());
		System.out.println(Lesson.XML.name());
		System.out.println(Lesson.JSP.name());
		System.out.println("--------");
		
		//���� ��ü�� ����(0���� ����)�� ��ȯ
		System.out.println(Lesson.JAVA.ordinal());
		System.out.println(Lesson.XML.ordinal());
		System.out.println(Lesson.JSP.ordinal());
	}
}
