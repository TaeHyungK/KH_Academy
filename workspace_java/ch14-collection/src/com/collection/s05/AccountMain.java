package com.collection.s05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.collection.s04.Product;

public class AccountMain {
	BufferedReader br;
	ArrayList<Account> list;

	public AccountMain() {
		br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<Account>();
	}

	// 메뉴
	public void input() throws IOException{
		while(true) {
			System.out.print("1.계좌생성 2.입금 3.출금 4.계좌정보 5.종료>");
			try {
				int num = Integer.parseInt(br.readLine());
				if(num==1) {
					register();
				}else if(num==2) {
					deposite();
				}else if(num==3) {
					withdraw();
				}else if(num==4) {
					getAccountList();
				}else if(num==5) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");

				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}

	}

	// 신규계좌 등록
	public void register() throws IOException {
		Account account = new Account();

		System.out.print("이름 입력> ");
		account.setName(br.readLine());

		System.out.print("계좌 입력> ");
		account.setAccount(br.readLine());

		System.out.print("예금 입력> ");
		account.setBalance(Integer.parseInt(br.readLine()));

		// ArrayList에 Product 저장
		list.add(account);
		
		System.out.println("계좌가 개설되었습니다.");
		System.out.println("-------------------------------------");
	}

	// 입금
	public void deposite() throws IOException {
		System.out.print("입금할 계좌 입력(종료:q)> ");
		String search = br.readLine();

		if (search.equals("q")) return;
		
		int index = 0;
		
		for(int i= 0;i<list.size();i++) {
			if(search.equals(list.get(i).getAccount())) {
				index = i;
			}
		}
		if(index>=0) {
			System.out.print("입금할 금액 입력> ");
			int balance = Integer.parseInt(br.readLine());
			
			list.get(index).deposite(balance);
			System.out.printf("현재 잔고는 %,d원 입니다.\n", list.get(index).getBalance());

		}
	}

	// 출금
	public void withdraw() throws IOException {
		System.out.print("출금할 계좌 입력(종료:q)> ");
		String search = br.readLine();
		
		if (search.equals("q")) return;
		
		int index = 0;
		
		for(int i= 0;i<list.size();i++) {
			if(search.equals(list.get(i).getAccount())) {
				index = i;
			}
		}
				
		if(index>=0) {
			System.out.print("출금할 금액 입력> ");
			int balance = Integer.parseInt(br.readLine());
			
			list.get(index).withdraw(balance);
			System.out.printf("현재 잔고는 %,d원 입니다.\n", list.get(index).getBalance());

		}
	}

	// 계좌정보
	public void getAccountList() {
		System.out.println("계좌 리스트 : 총 계좌수(" + list.size()+")");
		System.out.println("예금주\t계좌번호\t예치금");
		System.out.println("-------------------------------------");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getName() 
					+ "\t" + list.get(i).getAccount());
			System.out.printf("\t%,d원\n", list.get(i).getBalance());
		}

		System.out.println("-------------------------------------");
	}

	public static void main(String[] args) {
		AccountMain am = new AccountMain();
		try {
			am.input();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
