import java.util.Scanner;

public class IfMain04 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]�Է¹��� ���� 2���� ���� �ִ밪, �ּҰ��� ���Ͽ� ���
		 * [��¿���]
		 * �ִ밪 : 
		 * �ּҰ� : 
		 */
		
		Scanner input = new Scanner(System.in);
		
		int max,min;
		
		System.out.print("ù ��° ����: ");
		int a = input.nextInt();
		
		System.out.print("�� ��° ����: ");
		int b = input.nextInt();
		
		if(a>b) {
			max = a;
			min = b;
		}else {
			max = b;
			min = a;
		}
		
		System.out.println("�ִ밪 : " + max + "\n" +"�ּҰ� : " + min);
		
	}
}
