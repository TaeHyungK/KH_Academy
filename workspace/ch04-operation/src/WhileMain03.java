import java.util.Scanner;

public class WhileMain03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("�� �Է�: ");
		int dan = input.nextInt();
		int i = 1;
		

		System.out.printf("** %d�� **\n", dan);
		while(i<=9) {
			System.out.printf("%d * %d = %d\n", dan, i, (dan*i));
			i++;
		}
	}
}
