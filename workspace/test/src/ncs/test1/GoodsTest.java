package ncs.test1;

import java.util.Scanner;

public class GoodsTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ǰ��: ");
		String name = sc.nextLine();
		
		System.out.print("����: ");
		int price = sc.nextInt();
		
		System.out.print("����: ");
		int quantity = sc.nextInt();
		
		Goods goods = new Goods(name, price, quantity);
		
		System.out.println();
		System.out.println("�Էµ� ����� ������ �����ϴ�.");
		
		System.out.println(goods.toString());
		System.out.println("�� ���� ���� : " + goods.getPrice()*goods.getQuantity() + " ��");
		
	}
}
