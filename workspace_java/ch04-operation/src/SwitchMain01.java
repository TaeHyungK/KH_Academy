import java.util.Scanner;

public class SwitchMain01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("������ ���� �Է�> ");
		
		int a = input.nextInt();
		
		switch(a) {
			case 1:
				System.out.println("1 �Է�");
				break;
			case 2:
				System.out.println("2 �Է�");
				break;
			case 3:
				System.out.println("3 �Է�");
				break;				
			default:
				System.out.println("1,2,3�� �ƴ� ���� �Է�");
		}
		
	}
}
