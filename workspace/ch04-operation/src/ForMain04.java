import java.util.Scanner;

public class ForMain04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("�� �Է�: ");
		int dan = input.nextInt();
		
		System.out.println(dan + " ��");
		System.out.println("-----------");
		
		for(int i=1; i<=9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}
		
	}
}
