package com.util.s01;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateMain {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		//deprecated �Ǿ� ������� ����
//		System.out.println(now.toLocaleString());
		
		//��(����). ��. �� �ð� ���
		DateFormat df = DateFormat.getInstance();
		String today = df.format(now);
		System.out.println(today);
		System.out.println("-------------------");
		
		//��. ��. �� �ð� ���
		df = DateFormat.getDateTimeInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("-------------------");
		
		//��. ��. �� ���
		df = DateFormat.getDateInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("-------------------");
		
		//�ð� ���
		df = DateFormat.getTimeInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("-------------------");
//													��        ��    ��     ����  am/pm ��   ��   ��
		SimpleDateFormat sf = new SimpleDateFormat("yyyy��MM��dd�� (E) a hh:mm:ss");
		today = sf.format(now);
		System.out.println(today);
		
		
		
		
	}
}
