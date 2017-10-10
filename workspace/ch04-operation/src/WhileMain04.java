import java.util.Scanner;

public class WhileMain04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a, total=0;
		
		System.out.println("0전까지 입력받은 정수로 합 구하기");
		System.out.print("누적할 정수 데이터 입력: ");
		
		while((a = input.nextInt() )!=0) {
			total += a;
			System.out.print("누적할 정수 데이터 입력: ");			
		}
		
		System.out.println("total: "+total);

	}
}
