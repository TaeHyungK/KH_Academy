import java.util.Scanner;

public class OperatorEx05 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]A���� �븮�������� �׳� ���� �Ǹž��� 15%�� ������ �ֱ�� �߽��ϴ�.
		 * �Ǹ��� ��ǰ��� ��ǰ�� �ܰ��� ������ Ű����κ��� �Է¹޾� ���� �ݾ���
		 * ��½�Ű�� ���α׷��� �ۼ��Ͻÿ�. (��, ��½ÿ� �Ҽ����ϴ� ����)
		 * 
		 * [��¿���]
		 * ��ǰ�� �Է� : �����
		 * �ܰ� �Է� : 500000
		 * �Ǹ� ���� �Է� : 3
		 * ����� 3���� ������ 1,275,000��
		 * item= ��ǰ��, price= �ܰ�, quantity= ����, total= �հ� �ݾ�
		 */
		
		String item;
		int price, quantity, total;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("��ǰ�� �Է�: ");
		item = input.next();
		System.out.println("�ܰ� �Է�: ");
		price = input.nextInt();
		System.out.println("�Ǹ� ���� �Է�: ");
		quantity = input.nextInt();
		
		total = (int) (price*quantity*0.85);
		
		System.out.printf("%s %d���� ������ %,d��", item, price, total);
	}
}
