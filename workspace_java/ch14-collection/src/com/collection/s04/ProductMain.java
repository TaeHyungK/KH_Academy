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

	// 입력
	public void input() throws IOException {
		while (true) {
			try {
				System.out.print("1.상품입력 2.상품목록보기 3.종료> ");
				int num = Integer.parseInt(br.readLine());

				if (num == 1) {
					// Product 객체 생성
					Product p = new Product();
					// 상품명, 상품번호, 가격, 메이커, 재고수 입력
					System.out.print("상품명 입력> ");
					p.setName(br.readLine());

					System.out.print("상품번호 입력> ");
					p.setNum(br.readLine());

					System.out.print("상품가격 입력> ");
					p.setPrice(Integer.parseInt(br.readLine()));

					System.out.print("메이커 입력> ");
					p.setMaker(br.readLine());

					System.out.print("재고수 입력> ");
					p.setStock(Integer.parseInt(br.readLine()));
					
					// ArrayList에 Product 저장
					list.add(p);

				} else if (num == 2) {
					output();
				} else if (num == 3) {
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 허용");
			}
		}
	}

	// 출력
	public void output() {
		// 상품의 총개수 표시

		System.out.println("상품 리스트 : 총상품수(" + list.size()+")");
		System.out.println("상품명\t상품번호\t가격\t메이커\t재고수");
		System.out.println("-------------------------------------");
		// 상품명, 상품 번호, 가격, 메이커, 재고수 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() 
					+ "\t" + list.get(i).getNum() 
					+ "\t" + list.get(i).getPrice()
					+ "\t" + list.get(i).getMaker() 
					+ "\t" + list.get(i).getStock());
		}
		
		//확장 for문 이용
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
