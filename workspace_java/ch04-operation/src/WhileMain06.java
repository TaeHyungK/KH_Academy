import java.util.Scanner;

public class WhileMain06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a =0,total=0;
		
		System.out.println("0 ������ �Է¹��� ������ �� ���ϱ�");
		
		while(true) {
			System.out.print("������ ���� �Է�> ");
			a=input.nextInt();
			
			if(a==0)
				break;
			
			total += a;
		}
		
		System.out.println("total= " + total);
	}
}
