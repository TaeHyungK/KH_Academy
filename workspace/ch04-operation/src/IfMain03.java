import java.util.Scanner;

public class IfMain03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수 하나 입력: ");
		int a = input.nextInt();
		
		if(a%2==1)
			System.out.println("홀수입니다.");
		else
			System.out.println("짝수입니다.");
	}
}
