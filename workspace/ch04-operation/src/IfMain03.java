import java.util.Scanner;

public class IfMain03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("���� �ϳ� �Է�: ");
		int a = input.nextInt();
		
		if(a%2==1)
			System.out.println("Ȧ���Դϴ�.");
		else
			System.out.println("¦���Դϴ�.");
	}
}
