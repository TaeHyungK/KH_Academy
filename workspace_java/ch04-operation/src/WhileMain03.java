import java.util.Scanner;

public class WhileMain03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("단 입력: ");
		int dan = input.nextInt();
		int i = 1;
		

		System.out.printf("** %d단 **\n", dan);
		while(i<=9) {
			System.out.printf("%d * %d = %d\n", dan, i, (dan*i));
			i++;
		}
	}
}
