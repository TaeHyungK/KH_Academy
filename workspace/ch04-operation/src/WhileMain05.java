import java.util.Scanner;

public class WhileMain05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = 0, total=0;
		
		System.out.println("0전 까지 입력받은 정수로 합 구하기");
		
		while(true) {
			System.out.print("누적할 숫자 데이터 입력> ");
			a=input.nextInt();
			
			if(a!=0) {
				total += a;
			}else {
				System.out.println("total: " + total);
				break; // System.exit(0);
			}
			
		}
	}
}
