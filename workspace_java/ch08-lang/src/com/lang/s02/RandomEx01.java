package com.lang.s02;

import java.util.Scanner;

public class RandomEx01 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�] ���������� ����
		 * ����(1), ����(2),��(3)
		 * [�Է��ϼ���]
		 * 1:����, 2:����, 3:��, 4:���� > 1
		 * [���] ��ǻ��: ����, ��: ����> ����� �̰���!!
		 */
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.print("1:����, 2:����, 3:��, 4:���� >");
			int num = input.nextInt();
			String na="";
			String comStr="";
			
			if(num==4) break;
			
			//���� �߻�(1~3)
			int com = (int)(Math.random()*3+1);
			if(com == 1) comStr= "����";
			else if(com==2) comStr ="����";
			else if(com==3) comStr ="��";
			
			//����üũ�ؼ� ���� ���
			switch(num) {
			case 1://����
				na = "����";
				System.out.print("[���] ��ǻ��: " + comStr + ", ��: " + na +"> ");
				
				if(com == 1) System.out.println("�����ϴ�.");
				else if(com==2) System.out.println("����� �����ϴ�.");
				else if(com==3) System.out.println("����� �̰���ϴ�.");
				break;
			case 2://����
				na = "����";
				System.out.print("[���] ��ǻ��: " + comStr + ", ��: " + na +"> ");
				
				if(com == 1) System.out.println("����� �̰���ϴ�");
				else if(com==2) System.out.println("�����ϴ�.");
				else if(com==3) System.out.println("����� �����ϴ�.");
				break;
			case 3://��
				na = "��";
				System.out.print("[���] ��ǻ��: " + comStr + ", ��: " + na +"> ");
				
				if(com == 1) System.out.println("����� �����ϴ�.");
				else if(com==2) System.out.println("����� �̰���ϴ�.");
				else if(com==3) System.out.println("�����ϴ�.");
				break;
			}
			
			System.out.println("===========================");
		}
		
	}
}
