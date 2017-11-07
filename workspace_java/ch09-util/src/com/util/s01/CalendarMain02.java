package com.util.s01;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarMain02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Calendar cal = Calendar.getInstance();
		System.out.println("희망 연도와 월을 입력하세요");
		System.out.print("연도: ");
		int year = input.nextInt();
		System.out.print("월: ");
		int month = input.nextInt();
		
		System.out.println("    [ " + year + "년 " + month + "월 " +" ] ");
		System.out.println("======================");
		System.out.println("   일   월   화   수   목   금   토");
		
		//희망 연도, 월, 일 셋팅
		//(월의 범위는 0~11이기 때문에 실제월-1,
		//일은 달력이 `일부터 시작하기 때문에 1로 셋팅)
		//      연도          월          일
		cal.set(year, month-1, 1);
		
		//1일의 요일 구함(1일요일, 7토요일)
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		//마지막 날을 구함
		int lastOfDate = cal.getActualMaximum(Calendar.DATE);
		
		//1일이 시작하기 전 공백 만들기
		for(int i=1;i<week;i++) {
			System.out.print("   ");
		}
		
		for(int i=1;i<=lastOfDate;i++) {
//			System.out.print((i<10)? "  "+i : " "+i);
			System.out.printf("%3d", i);
			//토요일이면 줄바꿈
			//week값을 증가시키면서 week를 7로 나눈 나머지가 0인지 검사(=7의 배수검사)
			if(week%7==0) {
				System.out.println();
			}
			week++;
		}
		System.out.println("\n======================");
	}
}
