package com.util.s01;

import java.util.Calendar;

public class CalendarMain01 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today);

		int week_yy = today.get(Calendar.WEEK_OF_YEAR);
		int day_yy = today.get(Calendar.DAY_OF_YEAR);
		System.out.print("������ ���� " + week_yy + "��°�� ");
		System.out.print(day_yy + "��°�� ");

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int date = today.get(Calendar.DATE);
		
		System.out.print(year + "��  " + month + "�� " + date + "�� ");
		
		int day = today.get(Calendar.DAY_OF_WEEK);
		String nday = "";

		switch (day) {
		case 1:
			nday = "��"; break;
		case 2:
			nday = "ȭ"; break;
		case 3:
			nday = "��"; break;
		case 4:
			nday = "��"; break;
		case 5:
			nday = "��"; break;
		case 6:
			nday = "��"; break;
		case 7:
			nday = "��"; break;
		}
		
		System.out.print(nday + "���� ");
	
		int amPm = today.get(Calendar.AM_PM); // ���� 0, ���� 1
		int hour = today.get(Calendar.HOUR); // ��
		int min = today.get(Calendar.MINUTE); // ��
		int sec = today.get(Calendar.SECOND); // ��
		
		String str = (amPm == Calendar.AM) ? "����" : "����";
		
		System.out.println(str + " " + hour + "�� " + min + "�� " + sec + "��");
	}
}
