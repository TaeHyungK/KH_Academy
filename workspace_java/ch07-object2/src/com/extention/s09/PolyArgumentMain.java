package com.extention.s09;

class Product {
	int price; //제품 가격
	int bonusPoint; //제품 구매시 제공하는 보너스 점수
	
	public Product(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
	
	public String getName() {
		return "상품";
	}
}

class Tv extends Product{
	public Tv() {
		//부모클래스의 생성자 Product(int price) 호출
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
			System.out.println("잔액 부족으로 구매 불가");
			// 함수를 빠져나갈 때 사용!! break는 함수 내에서 사용 불가
			// 함수를 호출한 곳으로 되돌아감 -> 즉, 함수 종료
			return ; 
		}
		
		money -= p.price; // 차감
		bonusPoint += p.bonusPoint; //누적
		
		//구매 상품명 출력
		System.out.println(p.getName() + "을/를 구입했습니다.");
	}
}

public class PolyArgumentMain {
	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		Tv tv = new Tv();
		Computer com= new Computer();
		Audio audio = new Audio();
		
		//구매하기
		buyer.buy(tv);
		buyer.buy(com);
		buyer.buy(audio);
		
		System.out.println("현재 남은 돈은 "+buyer.money + "만원입니다.");
		System.out.println("현재 보너스 점수는 "+buyer.bonusPoint+"점입니다.");
	}
}
