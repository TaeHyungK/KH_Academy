import java.util.Scanner;

public class SwitchMain03 {
	public static void main(String[] args) {
		//JDK7.0���ʹ� switch�� ���ڰ����� ���ڿ� ���� ����
		Scanner input = new Scanner(System.in);
		
		int first = 0, second =0, result =0;
		String operator;
		
		System.out.print("ù ��° ��: ");
		first = input.nextInt();
		
		System.out.print("������: ");
		operator = input.next();
		
		System.out.print("�� ��° ��: ");
		second = input.nextInt();
		
		switch(operator) {
			case "+":
				result = first+second;
				break;
			case "-":
				result = first-second;
				break;
			case "*":
				result = first*second;
				break;
			case "/": 
				if(second != 0) {
					result = first/second;
					break;
				}
				else {
					System.out.println("0���� ���� �� �����ϴ�.");
					System.exit(0);
				}
			case "%":
				if(second != 0) {
					result = first%second;
					break;
				}
				else {
					System.out.println("0���� ���� �� �����ϴ�.");
					System.exit(0);
				}
			default :
				System.out.println("�����ڸ� �� �� �����ϼ̽��ϴ�.");
				//���α׷� ����
				System.exit(0);
		}
		
		System.out.println();
		System.out.println(first + " " + operator + " " + second + " = " + result);
		
	}
}
