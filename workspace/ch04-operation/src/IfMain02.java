import java.util.Scanner;

public class IfMain02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("������ ������ �Է�: ");
		int a = input.nextInt();
		
		//���๮�� �� ���� ��쿡 �߰�ȣ ���� ����
		if(a<0) 
			a = -a;
		
		System.out.println("���밪�� " + a);
		
	}
}
