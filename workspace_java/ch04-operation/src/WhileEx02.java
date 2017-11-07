import java.util.Scanner;

public class WhileEx02 {
	public static void main(String[] args) {
		System.out.println("====���Ǳ� ���α׷�====");

		Scanner input = new Scanner(System.in);
		// Ŀ�� ����
		int price = 300;

		// Ŀ�� �ֹ��� �Һ�Ǵ� ��
		int content_coffee = 5;
		int content_cream = 3;
		int content_sugar = 1;

		// Ŀ�ǿ� �� ����� ���� ������
		int coffee = 10;
		int cream = 10;
		int sugar = 10;

		// ���� �ݾ�
		int amount = 0;
		// ���� ����
		int coin = 1000;

		while (true) {
			System.out.print("1.Ŀ�� ���ñ� 2.���� 3.������ ���> ");
			int num = input.nextInt();

			if (num == 1) {
				// ���� �Է�
				System.out.print("���� �Է�: ");
				int payment = input.nextInt();

				// �Ž����� ���ϱ�
				int balance = payment - price;

				// Ŀ��, ����, ���� üũ
				if (coffee >= content_coffee 
						&& cream >= content_cream 
						&& sugar >= content_sugar) {
				
					// Ŀ�Ǹ� ������ �� ������ ���Ű����̶�� ���
					if (coin >= balance) {
						// ������ ���� ����
						amount += payment;
						// ���� ���� ����
						coin -= balance;

						// Ŀ��, ����, ���� ����
						coffee -= content_coffee;
						cream -= content_cream;
						sugar -= content_sugar;
						// �Ž����� ���
						System.out.println("�Ž��� ��: " + balance);
						System.out.println("Ŀ�ǰ� �غ�Ǿ����ϴ�.");
						System.out.println("===���� ���Ǳ� ����===");
						System.out.println("������ �ݾ�: " + amount);
						System.out.println("���� ���� �ݾ�: " + coin);
						System.out.println("Ŀ�� ���� ��: " + coffee);
						System.out.println("���� ���� ��: " + cream);
						System.out.println("���� ���� ��: " + sugar);
						System.out.println("=================");
					} else {
						System.out.println("�ܵ� ���� \nĿ�� ���� �Ұ�");
					}
				} else {
					System.out.println("Ŀ�� ��� ���� \nĿ�� ���� �Ұ�");
				}

			} else if (num == 2) {
				System.out.println("���Ǳ� ���α׷� ����");
				break;
			} else if (num == 3) {
				while (true) {
					System.out.println("===������ ���===");

					System.out.print("1.���Ǳ� �� ȸ�� 2.�ܵ� �߰� 3.Ŀ�� �߰� \n4.���� �߰� 5.���� �߰� 6.���Ǳ� ��Ȳ ��ȸ \n7.������ ��� ���� \n>");
					int num2 = input.nextInt();

					if (num2 == 1) {
						System.out.println("���Ǳ� ���� ���� �ݾ�: " + amount);
						System.out.print("ȸ���� �ݾ� �Է�: ");
						int money = input.nextInt();

						amount -= money;
						System.out.println("ȸ�� �� ���Ǳ� ���� �ݾ�: " + amount);
					} else if (num2 == 2) {
						System.out.println("���Ǳ� ���� ���� ����: " + coin);
						System.out.print("�߰��� �ݾ� �Է�: ");
						int money = input.nextInt();

						coin += money;
						System.out.println("�߰� �� ���Ǳ� ���� ����: " + coin);
					} else if (num2 == 3) {
						System.out.println("���Ǳ� ���� ���� Ŀ�Ƿ�: " + coffee);
						System.out.print("�߰��� Ŀ�Ƿ� �Է�: ");
						int plus_coffee = input.nextInt();

						coffee += plus_coffee;
						System.out.println("�߰� �� ���� ���� Ŀ�Ƿ�: " + coffee);
					} else if (num2 == 4) {
						System.out.println("���Ǳ� ���� ���� ������: " + cream);
						System.out.print("�߰��� ������ �Է�: ");
						int plus_cream = input.nextInt();

						cream += plus_cream;
						System.out.println("�߰� �� ���� ���� ������: " + cream);
					} else if (num2 == 5) {
						System.out.println("���Ǳ� ���� ���� ������: " + sugar);
						System.out.print("�߰��� ������ �Է�: ");
						int plus_sugar = input.nextInt();

						sugar += plus_sugar;
						System.out.println("�߰� �� ���� ���� ������: " + sugar);
					} else if (num2 == 6) {
						System.out.println("===���� ���Ǳ� ����===");
						System.out.println("������ �ݾ�: " + amount);
						System.out.println("���� ���� �ݾ�: " + coin);
						System.out.println("Ŀ�� ���� ��: " + coffee);
						System.out.println("���� ���� ��: " + cream);
						System.out.println("���� ���� ��: " + sugar);
						System.out.println("=================");
					} else if (num2 == 7) {
						break;
					} else {
						System.out.println("1~7�� �Է��Ͻÿ�.");
					}
				}

			} else {
				System.out.println("1 �Ǵ� 2�� �Է����ּ���.");
			}

		}

	}
}
