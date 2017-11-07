import java.util.Scanner;

public class DoWhileMain02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a=0, total=0;
		
		System.out.println("0전까지 입력받은 정수 합 구하기");
		
		do {
			total +=a;
			System.out.print("누적할 정수 입력: " );
			
		}while((a = input.nextInt())!=0);
		
		System.out.println("total= " + total);
		
	}
	
}
