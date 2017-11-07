public class WhileEx02_teacher {
	public static void main(String[] args) {
		System.out.println("===자판기프로그램===");
		
		java.util.Scanner input =
				new java.util.Scanner(System.in);
		
		//커피정보
		int price = 300;
		//커피 주문시 소비되는 양
		int content_coffe = 5;
		int content_cream = 3;
		int content_sugar = 1;
		
		//커피에 들어갈 재료의 현재 보유량
		int coffee = 10;
		int cream = 10;
		int sugar = 10;
		
		//보유금액
		int amount = 0;
		
		//보유동전
		int coin = 1000;
		
		while(true) {
			System.out.print("1:커피마시기,2:종료>");
			int num = input.nextInt();
			
			if(num==1) {
				System.out.print("동전 투입>");
				int payment = input.nextInt();
				
				//거스름돈
				int change = payment-price;
				
				//커피,프림,설탕 체크
				
				//거스름돈 부족 여부 체크
				if(coin < change) {
					System.out.println("거스름돈 부족!");
					continue;
				}
				
				//커피,프림,설탕 차감
				
				//거스름돈 차감
				coin -= change;
				//투입한 금액 누적
				amount += payment;
				
				//거스름돈 출력
				System.out.println("거스름돈 : " + change);
				System.out.println(
						"맛 좋은 커피가 준비되었습니다.");
				
				System.out.println("===현재 자판기 정보===");
				//커피,프림,설탕 보유량 출력
				System.out.println("동전보유금액 : " + coin);
				System.out.println("투입한 금액 : " + amount);
				System.out.println("=====================");
				
			}else if(num==2) {
				System.out.println("자판기 프로그램 종료");
				break;
			}else {
				System.out.println("잘못입력했습니다.");
			}
		}
		
	}
}




