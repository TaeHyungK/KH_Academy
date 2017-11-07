import java.util.Scanner;

public class WhileEx02 {
	public static void main(String[] args) {
		System.out.println("====자판기 프로그램====");

		Scanner input = new Scanner(System.in);
		// 커피 정보
		int price = 300;

		// 커피 주문시 소비되는 양
		int content_coffee = 5;
		int content_cream = 3;
		int content_sugar = 1;

		// 커피에 들어갈 재료의 현재 보유랑
		int coffee = 10;
		int cream = 10;
		int sugar = 10;

		// 보유 금액
		int amount = 0;
		// 보유 동전
		int coin = 1000;

		while (true) {
			System.out.print("1.커피 마시기 2.종료 3.관리자 모드> ");
			int num = input.nextInt();

			if (num == 1) {
				// 동전 입력
				System.out.print("동전 입력: ");
				int payment = input.nextInt();

				// 거스름돈 구하기
				int balance = payment - price;

				// 커피, 프림, 설탕 체크
				if (coffee >= content_coffee 
						&& cream >= content_cream 
						&& sugar >= content_sugar) {
				
					// 커피를 구매할 수 있으면 구매가능이라고 출력
					if (coin >= balance) {
						// 투입한 동전 누적
						amount += payment;
						// 보유 동전 차감
						coin -= balance;

						// 커피, 프림, 설탕 차감
						coffee -= content_coffee;
						cream -= content_cream;
						sugar -= content_sugar;
						// 거스름돈 출력
						System.out.println("거스름 돈: " + balance);
						System.out.println("커피가 준비되었습니다.");
						System.out.println("===현재 자판기 정보===");
						System.out.println("투입한 금액: " + amount);
						System.out.println("동전 보유 금액: " + coin);
						System.out.println("커피 남은 양: " + coffee);
						System.out.println("프림 남은 양: " + cream);
						System.out.println("설탕 남은 양: " + sugar);
						System.out.println("=================");
					} else {
						System.out.println("잔돈 부족 \n커피 구매 불가");
					}
				} else {
					System.out.println("커피 재료 부족 \n커피 구매 불가");
				}

			} else if (num == 2) {
				System.out.println("자판기 프로그램 종료");
				break;
			} else if (num == 3) {
				while (true) {
					System.out.println("===관리자 모드===");

					System.out.print("1.자판기 돈 회수 2.잔돈 추가 3.커피 추가 \n4.프림 추가 5.설탕 추가 6.자판기 상황 조회 \n7.관리자 모드 종료 \n>");
					int num2 = input.nextInt();

					if (num2 == 1) {
						System.out.println("자판기 현재 보유 금액: " + amount);
						System.out.print("회수할 금액 입력: ");
						int money = input.nextInt();

						amount -= money;
						System.out.println("회수 후 자판기 보유 금액: " + amount);
					} else if (num2 == 2) {
						System.out.println("자판기 현재 보유 동전: " + coin);
						System.out.print("추가할 금액 입력: ");
						int money = input.nextInt();

						coin += money;
						System.out.println("추가 후 자판기 보유 동전: " + coin);
					} else if (num2 == 3) {
						System.out.println("자판기 현재 보유 커피량: " + coffee);
						System.out.print("추가할 커피량 입력: ");
						int plus_coffee = input.nextInt();

						coffee += plus_coffee;
						System.out.println("추가 후 현재 보유 커피량: " + coffee);
					} else if (num2 == 4) {
						System.out.println("자판기 현재 보유 프림량: " + cream);
						System.out.print("추가할 프림량 입력: ");
						int plus_cream = input.nextInt();

						cream += plus_cream;
						System.out.println("추가 후 현재 보유 프림량: " + cream);
					} else if (num2 == 5) {
						System.out.println("자판기 현재 보유 설탕량: " + sugar);
						System.out.print("추가할 설탕량 입력: ");
						int plus_sugar = input.nextInt();

						sugar += plus_sugar;
						System.out.println("추가 후 현재 보유 설탕량: " + sugar);
					} else if (num2 == 6) {
						System.out.println("===현재 자판기 정보===");
						System.out.println("투입한 금액: " + amount);
						System.out.println("동전 보유 금액: " + coin);
						System.out.println("커피 남은 양: " + coffee);
						System.out.println("프림 남은 양: " + cream);
						System.out.println("설탕 남은 양: " + sugar);
						System.out.println("=================");
					} else if (num2 == 7) {
						break;
					} else {
						System.out.println("1~7을 입력하시오.");
					}
				}

			} else {
				System.out.println("1 또는 2를 입력해주세요.");
			}

		}

	}
}
