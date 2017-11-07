package com.collection.s04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProductMain {
	BufferedReader br;
	ArrayList<Product> list;

	public ProductMain() {
		br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<Product>();
	}

	// �Է�
	public void input() throws IOException {
		while (true) {
			try {
				System.out.print("1.��ǰ�Է� 2.��ǰ��Ϻ��� 3.����> ");
				int num = Integer.parseInt(br.readLine());

				if (num == 1) {
					// Product ��ü ����
					Product p = new Product();
					// ��ǰ��, ��ǰ��ȣ, ����, ����Ŀ, ���� �Է�
					System.out.print("��ǰ�� �Է�> ");
					p.setName(br.readLine());

					System.out.print("��ǰ��ȣ �Է�> ");
					p.setNum(br.readLine());

					System.out.print("��ǰ���� �Է�> ");
					p.setPrice(Integer.parseInt(br.readLine()));

					System.out.print("����Ŀ �Է�> ");
					p.setMaker(br.readLine());

					System.out.print("���� �Է�> ");
					p.setStock(Integer.parseInt(br.readLine()));
					
					// ArrayList�� Product ����
					list.add(p);

				} else if (num == 2) {
					output();
				} else if (num == 3) {
					System.out.println("���α׷� ����");
					break;
				} else {
					System.out.println("�߸� �Է��߽��ϴ�.");
				}
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� ���");
			}
		}
	}

	// ���
	public void output() {
		// ��ǰ�� �Ѱ��� ǥ��

		System.out.println("��ǰ ����Ʈ : �ѻ�ǰ��(" + list.size()+")");
		System.out.println("��ǰ��\t��ǰ��ȣ\t����\t����Ŀ\t����");
		System.out.println("-------------------------------------");
		// ��ǰ��, ��ǰ ��ȣ, ����, ����Ŀ, ���� ���
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() 
					+ "\t" + list.get(i).getNum() 
					+ "\t" + list.get(i).getPrice()
					+ "\t" + list.get(i).getMaker() 
					+ "\t" + list.get(i).getStock());
		}
		
		//Ȯ�� for�� �̿�
		for(Product p : list) {
			System.out.println(p.getName() 
					+ "\t" + p.getNum() 
					+ "\t" + p.getPrice()
					+ "\t" + p.getMaker() 
					+ "\t" + p.getStock());
		}
		System.out.println("-------------------------------------");
	}

	public static void main(String[] args) {
		ProductMain pm = new ProductMain();
		try {
			pm.input();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
