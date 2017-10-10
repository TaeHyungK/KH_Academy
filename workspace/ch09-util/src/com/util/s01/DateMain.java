package com.util.s01;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateMain {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		//deprecated 되어 사용하지 않음
//		System.out.println(now.toLocaleString());
		
		//연(단축). 월. 일 시간 출력
		DateFormat df = DateFormat.getInstance();
		String today = df.format(now);
		System.out.println(today);
		System.out.println("-------------------");
		
		//연. 월. 일 시간 출력
		df = DateFormat.getDateTimeInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("-------------------");
		
		//연. 월. 일 출력
		df = DateFormat.getDateInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("-------------------");
		
		//시간 출력
		df = DateFormat.getTimeInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("-------------------");
//													년        월    일     요일  am/pm 시   분   초
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년MM월dd일 (E) a hh:mm:ss");
		today = sf.format(now);
		System.out.println(today);
		
		
		
		
	}
}
