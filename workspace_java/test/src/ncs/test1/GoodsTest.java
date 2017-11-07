package ncs.test1;

import java.util.Scanner;

public class GoodsTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("상품명: ");
		String name = sc.nextLine();
		
		System.out.print("가격: ");
		int price = sc.nextInt();
		
		System.out.print("수량: ");
		int quantity = sc.nextInt();
		
		Goods goods = new Goods(name, price, quantity);
		
		System.out.println();
		System.out.println("입력된 결과는 다음과 같습니다.");
		
		System.out.println(goods.toString());
		System.out.println("총 구매 가격 : " + goods.getPrice()*goods.getQuantity() + " 원");
		
	}
}
