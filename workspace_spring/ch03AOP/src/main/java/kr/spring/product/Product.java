package kr.spring.product;

public class Product {
	//핵심 기능 수행
	public String launch() {
		System.out.println("launch 메서드 호출");
		
		//예외 발생시 호출되는 공통관심사항을 테스트하기 위해서 예외 발생
		//System.out.println(20/0);
		
		return "[상품 출시]";
	}
}
