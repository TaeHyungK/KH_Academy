package com.extention.s09;

class Product {
	int price; //��ǰ ����
	int bonusPoint; //��ǰ ���Ž� �����ϴ� ���ʽ� ����
	
	public Product(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
	
	public String getName() {
		return "��ǰ";
	}
}

class Tv extends Product{
	public Tv() {
		//�θ�Ŭ������ ������ Product(int price) ȣ��
		super(100);
	}
	
	@Override
	public String getName() {
		return "TV";
	}	
}

class Computer extends Product{
	public Computer() {
		super(200);
	}
	
	@Override
	public String getName() {
		return "Computer";
	}
}

class Audio extends Product{
	public Audio() {
		super(300);
	}
	
	@Override
	public String getName() {
		return "Audio";
	}
}

class Buyer{
	int money = 1000;
	int bonusPoint = 0;
	
	public void buy(Product p) {
		if(money < p.price) {
			System.out.println("�ܾ� �������� ���� �Ұ�");
			// �Լ��� �������� �� ���!! break�� �Լ� ������ ��� �Ұ�
			// �Լ��� ȣ���� ������ �ǵ��ư� -> ��, �Լ� ����
			return ; 
		}
		
		money -= p.price; // ����
		bonusPoint += p.bonusPoint; //����
		
		//���� ��ǰ�� ���
		System.out.println(p.getName() + "��/�� �����߽��ϴ�.");
	}
}

public class PolyArgumentMain {
	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		Tv tv = new Tv();
		Computer com= new Computer();
		Audio audio = new Audio();
		
		//�����ϱ�
		buyer.buy(tv);
		buyer.buy(com);
		buyer.buy(audio);
		
		System.out.println("���� ���� ���� "+buyer.money + "�����Դϴ�.");
		System.out.println("���� ���ʽ� ������ "+buyer.bonusPoint+"���Դϴ�.");
	}
}
