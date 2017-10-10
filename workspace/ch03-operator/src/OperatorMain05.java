import java.util.Scanner;

public class OperatorMain05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a, b;
		boolean result;
		
		System.out.println("첫 번째 정수 : ");
		a = input.nextInt();
		
		System.out.println("두 번재 정수 : ");
		b = input.nextInt();
		
		result = a > b;
		System.out.println(a + " > " + b + " : " + result);
		
		
		
	}
}
