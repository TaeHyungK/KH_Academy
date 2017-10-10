import java.util.Scanner;

public class OperatorEx05 {
	public static void main(String[] args) {
		/*
		 * [실습]A전자 대리점에서는 그날 물건 판매액의 15%를 할인해 주기로 했습니다.
		 * 판매한 상품명과 상품의 단가와 수량을 키보드로부터 입력받아 지불 금액을
		 * 출력시키는 프로그램을 작성하시오. (단, 출력시에 소수이하는 절삭)
		 * 
		 * [출력예시]
		 * 상품명 입력 : 냉장고
		 * 단가 입력 : 500000
		 * 판매 수량 입력 : 3
		 * 냉장고 3대의 가격은 1,275,000원
		 * item= 상품명, price= 단가, quantity= 수량, total= 합계 금액
		 */
		
		String item;
		int price, quantity, total;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("상품명 입력: ");
		item = input.next();
		System.out.println("단가 입력: ");
		price = input.nextInt();
		System.out.println("판매 수량 입력: ");
		quantity = input.nextInt();
		
		total = (int) (price*quantity*0.85);
		
		System.out.printf("%s %d대의 가격은 %,d원", item, price, total);
	}
}
