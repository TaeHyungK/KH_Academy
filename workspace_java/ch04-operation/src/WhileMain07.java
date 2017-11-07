import java.util.Scanner;

public class WhileMain07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//잔고
		int balance =0;
		
		while(true) {
			System.out.println("-----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고확인 | 4. 종료");
			System.out.println("-----------------------------------");
			System.out.print("번호 선택> ");
			
			//선택한 번호
			int num = input.nextInt();
			
			if(num==1) {//입금
				System.out.print("예금액> ");
				balance += input.nextInt();
			}else if(num==2) {//출금
				System.out.print("출금액> ");
				balance -= input.nextInt();
			}else if(num==3) {//잔고확인
				System.out.printf("잔고: %,d원\n", balance);
			}else if(num==4) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못 입력했습니다.");
			}
			
		}
		
	}
}
