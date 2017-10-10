package com.instance.s04;

import java.util.Scanner;

public class AccountMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account account = null;
		
		int money;
		
		while(true) {
			System.out.println("---------------------------------------------");
			System.out.println("1.계좌생성 | 2.예금하기 | 3.출금하기 | 4.계좌정보 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.print("번호 선택> ");
			int num = input.nextInt();
			
			if(num==1) {//계좌생성
				System.out.print("계좌번호 입력: ");
				String mAccountNum = input.next();
				System.out.print("이름 입력: ");
				String mName = input.next();
				
				account = new Account(mAccountNum,mName,0);
				System.out.println("계좌가 생성되었습니다.\n초기 잔고는 0원입니다.");
			}else if(num==2) {//예금하기
				if(account == null) {
					System.out.println("가입한 계좌가 없습니다.");
					continue;
				}else {
					System.out.print("입금할 금액: ");
					money = input.nextInt();
					account.deposite(money);
					System.out.println("예금이 완료되었습니다.");
				}
			}else if(num==3) {//출금하기
				if(account == null) {
					System.out.println("가입한 계좌가 없습니다.");
					continue;
				}else {
					System.out.print("출금할 금액: ");
					money = input.nextInt();
					account.withdraw(money);
					System.out.println("출금이 완료되었습니다.");
				}
			}else if(num==4) {//계좌정보 조회
				if(account == null) {
					System.out.println("가입한 계좌가 없습니다.");
					continue;
				}else {
					System.out.println("계좌번호: "+ account.getAccount_Num());
					System.out.println("예금주: " + account.getName());
					System.out.println("소유 금액: " + account.getBalance());
					
				}
			}else if(num==5) {
				System.out.println("은행프로그램 종료");
				break;
			}else {
				System.out.println("1~5를 입력해주세요.");
			}
			
		}
	}
}
