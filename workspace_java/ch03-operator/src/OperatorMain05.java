import java.util.Scanner;

public class OperatorMain05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a, b;
		boolean result;
		
		System.out.println("ù ��° ���� : ");
		a = input.nextInt();
		
		System.out.println("�� ���� ���� : ");
		b = input.nextInt();
		
		result = a > b;
		System.out.println(a + " > " + b + " : " + result);
		
		
		
	}
}
