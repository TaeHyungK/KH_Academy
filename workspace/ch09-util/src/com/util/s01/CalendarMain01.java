package com.util.s01;

import java.util.Calendar;

public class CalendarMain01 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today);

		int week_yy = today.get(Calendar.WEEK_OF_YEAR);
		int day_yy = today.get(Calendar.DAY_OF_YEAR);
		System.out.print("오늘은 연중 " + week_yy + "주째고 ");
		System.out.print(day_yy + "일째인 ");

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int date = today.get(Calendar.DATE);
		
		System.out.print(year + "년  " + month + "월 " + date + "일 ");
		
		int day = today.get(Calendar.DAY_OF_WEEK);
		String nday = "";

		switch (day) {
		case 1:
			nday = "월"; break;
		case 2:
			nday = "화"; break;
		case 3:
			nday = "수"; break;
		case 4:
			nday = "목"; break;
		case 5:
			nday = "금"; break;
		case 6:
			nday = "토"; break;
		case 7:
			nday = "일"; break;
		}
		
		System.out.print(nday + "요일 ");
	
		int amPm = today.get(Calendar.AM_PM); // 오전 0, 오후 1
		int hour = today.get(Calendar.HOUR); // 시
		int min = today.get(Calendar.MINUTE); // 분
		int sec = today.get(Calendar.SECOND); // 초
		
		String str = (amPm == Calendar.AM) ? "오전" : "오후";
		
		System.out.println(str + " " + hour + "시 " + min + "분 " + sec + "초");
	}
}
