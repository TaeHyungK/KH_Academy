import java.util.Scanner;

public class SwitchMain01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수형 숫자 입력> ");
		
		int a = input.nextInt();
		
		switch(a) {
			case 1:
				System.out.println("1 입력");
				break;
			case 2:
				System.out.println("2 입력");
				break;
			case 3:
				System.out.println("3 입력");
				break;				
			default:
				System.out.println("1,2,3이 아닌 숫자 입력");
		}
		
	}
}
