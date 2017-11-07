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

	// �޴�
	public void input() throws IOException{
		while(true) {
			System.out.print("1.���»��� 2.�Ա� 3.��� 4.�������� 5.����>");
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
					System.out.println("���α׷� ����");
					break;
				}else {
					System.out.println("�߸� �Է��߽��ϴ�.");

				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}

	}

	// �ű԰��� ���
	public void register() throws IOException {
		Account account = new Account();

		System.out.print("�̸� �Է�> ");
		account.setName(br.readLine());

		System.out.print("���� �Է�> ");
		account.setAccount(br.readLine());

		System.out.print("���� �Է�> ");
		account.setBalance(Integer.parseInt(br.readLine()));

		// ArrayList�� Product ����
		list.add(account);
		
		System.out.println("���°� �����Ǿ����ϴ�.");
		System.out.println("-------------------------------------");
	}

	// �Ա�
	public void deposite() throws IOException {
		System.out.print("�Ա��� ���� �Է�(����:q)> ");
		String search = br.readLine();

		if (search.equals("q")) return;
		
		int index = 0;
		
		for(int i= 0;i<list.size();i++) {
			if(search.equals(list.get(i).getAccount())) {
				index = i;
			}
		}
		if(index>=0) {
			System.out.print("�Ա��� �ݾ� �Է�> ");
			int balance = Integer.parseInt(br.readLine());
			
			list.get(index).deposite(balance);
			System.out.printf("���� �ܰ�� %,d�� �Դϴ�.\n", list.get(index).getBalance());

		}
	}

	// ���
	public void withdraw() throws IOException {
		System.out.print("����� ���� �Է�(����:q)> ");
		String search = br.readLine();
		
		if (search.equals("q")) return;
		
		int index = 0;
		
		for(int i= 0;i<list.size();i++) {
			if(search.equals(list.get(i).getAccount())) {
				index = i;
			}
		}
				
		if(index>=0) {
			System.out.print("����� �ݾ� �Է�> ");
			int balance = Integer.parseInt(br.readLine());
			
			list.get(index).withdraw(balance);
			System.out.printf("���� �ܰ�� %,d�� �Դϴ�.\n", list.get(index).getBalance());

		}
	}

	// ��������
	public void getAccountList() {
		System.out.println("���� ����Ʈ : �� ���¼�(" + list.size()+")");
		System.out.println("������\t���¹�ȣ\t��ġ��");
		System.out.println("-------------------------------------");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getName() 
					+ "\t" + list.get(i).getAccount());
			System.out.printf("\t%,d��\n", list.get(i).getBalance());
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
