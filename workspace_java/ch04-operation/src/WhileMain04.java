import java.util.Scanner;

public class WhileMain04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a, total=0;
		
		System.out.println("0������ �Է¹��� ������ �� ���ϱ�");
		System.out.print("������ ���� ������ �Է�: ");
		
		while((a = input.nextInt() )!=0) {
			total += a;
			System.out.print("������ ���� ������ �Է�: ");			
		}
		
		System.out.println("total: "+total);

	}
}
