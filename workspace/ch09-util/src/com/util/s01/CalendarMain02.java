package com.util.s01;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarMain02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Calendar cal = Calendar.getInstance();
		System.out.println("��� ������ ���� �Է��ϼ���");
		System.out.print("����: ");
		int year = input.nextInt();
		System.out.print("��: ");
		int month = input.nextInt();
		
		System.out.println("    [ " + year + "�� " + month + "�� " +" ] ");
		System.out.println("======================");
		System.out.println("   ��   ��   ȭ   ��   ��   ��   ��");
		
		//��� ����, ��, �� ����
		//(���� ������ 0~11�̱� ������ ������-1,
		//���� �޷��� `�Ϻ��� �����ϱ� ������ 1�� ����)
		//      ����          ��          ��
		cal.set(year, month-1, 1);
		
		//1���� ���� ����(1�Ͽ���, 7�����)
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		//������ ���� ����
		int lastOfDate = cal.getActualMaximum(Calendar.DATE);
		
		//1���� �����ϱ� �� ���� �����
		for(int i=1;i<week;i++) {
			System.out.print("   ");
		}
		
		for(int i=1;i<=lastOfDate;i++) {
//			System.out.print((i<10)? "  "+i : " "+i);
			System.out.printf("%3d", i);
			//������̸� �ٹٲ�
			//week���� ������Ű�鼭 week�� 7�� ���� �������� 0���� �˻�(=7�� ����˻�)
			if(week%7==0) {
				System.out.println();
			}
			week++;
		}
		System.out.println("\n======================");
	}
}
