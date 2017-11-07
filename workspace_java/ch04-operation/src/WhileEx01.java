import java.util.Scanner;

public class WhileEx01 {
	public static void main(String[] args) {
		/*
		 * [실습]커피값이 4,000원입니다. 마실 커피 수량을 입력하고 돈을 지불 하세요.
		 * 지불한 돈에서 발생한 거스름돈을 출력하고 상품의 총 비용보다 지불한 돈이 적어서
		 * 적어서 상품을 구매할 수 없는 경우 "금액이 부족합니다."라고 알려준 후 다시 지불할
		 * 수 있는 프로그램을 작성하시오. 
		 */
		Scanner input = new Scanner(System.in);
		int price = 4000;
		// 	수량		   거스름돈	     지불한금액	
		int quantity, balance, payment, total;

		//구매 수량 입력
		System.out.print("구매 수량 입력> ");
		quantity = input.nextInt();
		
		while(true) {
			//지불 금액
			System.out.print("지불 금액 입력> ");
			payment = input.nextInt();
			//총 비용 연산
			total = price*quantity;
			//거스름돈 연산
			balance = payment-total;			
			//조건: 거스름돈이 0이상이면 반복문 탈출
			if(balance >= 0)
				break;
			else {
				balance *= -1;
				System.out.printf("지불금액 부족(%,d원이 부족합니다.)\n", balance);
			}
			//거스름돈 부족시 "거스름돈 부족(300원이 부족합니다.)" 출력
		}
		
		System.out.printf("거스름돈= %,d원", balance);
		
	}
}
