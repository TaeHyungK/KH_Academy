import java.util.Scanner;

public class WhileEx01 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]Ŀ�ǰ��� 4,000���Դϴ�. ���� Ŀ�� ������ �Է��ϰ� ���� ���� �ϼ���.
		 * ������ ������ �߻��� �Ž������� ����ϰ� ��ǰ�� �� ��뺸�� ������ ���� ���
		 * ��� ��ǰ�� ������ �� ���� ��� "�ݾ��� �����մϴ�."��� �˷��� �� �ٽ� ������
		 * �� �ִ� ���α׷��� �ۼ��Ͻÿ�. 
		 */
		Scanner input = new Scanner(System.in);
		int price = 4000;
		// 	����		   �Ž�����	     �����ѱݾ�	
		int quantity, balance, payment, total;

		//���� ���� �Է�
		System.out.print("���� ���� �Է�> ");
		quantity = input.nextInt();
		
		while(true) {
			//���� �ݾ�
			System.out.print("���� �ݾ� �Է�> ");
			payment = input.nextInt();
			//�� ��� ����
			total = price*quantity;
			//�Ž����� ����
			balance = payment-total;			
			//����: �Ž������� 0�̻��̸� �ݺ��� Ż��
			if(balance >= 0)
				break;
			else {
				balance *= -1;
				System.out.printf("���ұݾ� ����(%,d���� �����մϴ�.)\n", balance);
			}
			//�Ž����� ������ "�Ž����� ����(300���� �����մϴ�.)" ���
		}
		
		System.out.printf("�Ž�����= %,d��", balance);
		
	}
}
