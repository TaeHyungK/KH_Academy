import java.util.Scanner;

public class DoWhileMain02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a=0, total=0;
		
		System.out.println("0������ �Է¹��� ���� �� ���ϱ�");
		
		do {
			total +=a;
			System.out.print("������ ���� �Է�: " );
			
		}while((a = input.nextInt())!=0);
		
		System.out.println("total= " + total);
		
	}
	
}
