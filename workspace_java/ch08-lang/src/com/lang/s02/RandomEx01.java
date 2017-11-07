package com.lang.s02;

import java.util.Scanner;

public class RandomEx01 {
	public static void main(String[] args) {
		/*
		 * [실습] 가위바위보 게임
		 * 가위(1), 바위(2),보(3)
		 * [입력하세요]
		 * 1:가위, 2:바위, 3:보, 4:종료 > 1
		 * [결과] 컴퓨터: 가위, 나: 바위> 당신이 이겼어요!!
		 */
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.print("1:가위, 2:바위, 3:보, 4:종료 >");
			int num = input.nextInt();
			String na="";
			String comStr="";
			
			if(num==4) break;
			
			//난수 발생(1~3)
			int com = (int)(Math.random()*3+1);
			if(com == 1) comStr= "가위";
			else if(com==2) comStr ="바위";
			else if(com==3) comStr ="보";
			
			//조건체크해서 승패 출력
			switch(num) {
			case 1://가위
				na = "가위";
				System.out.print("[결과] 컴퓨터: " + comStr + ", 나: " + na +"> ");
				
				if(com == 1) System.out.println("비겼습니다.");
				else if(com==2) System.out.println("당신이 졌습니다.");
				else if(com==3) System.out.println("당신이 이겼습니다.");
				break;
			case 2://바위
				na = "바위";
				System.out.print("[결과] 컴퓨터: " + comStr + ", 나: " + na +"> ");
				
				if(com == 1) System.out.println("당신이 이겼습니다");
				else if(com==2) System.out.println("비겼습니다.");
				else if(com==3) System.out.println("당신이 졌습니다.");
				break;
			case 3://보
				na = "보";
				System.out.print("[결과] 컴퓨터: " + comStr + ", 나: " + na +"> ");
				
				if(com == 1) System.out.println("당신이 졌습니다.");
				else if(com==2) System.out.println("당신이 이겼습니다.");
				else if(com==3) System.out.println("비겼습니다.");
				break;
			}
			
			System.out.println("===========================");
		}
		
	}
}
