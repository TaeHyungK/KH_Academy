import java.util.Scanner;

public class WhileMain06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a =0,total=0;
		
		System.out.println("0 전까지 입력받은 정수로 합 구하기");
		
		while(true) {
			System.out.print("누적할 숫자 입력> ");
			a=input.nextInt();
			
			if(a==0)
				break;
			
			total += a;
		}
		
		System.out.println("total= " + total);
	}
}
