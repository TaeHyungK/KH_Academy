public class WhileEx02_teacher {
	public static void main(String[] args) {
		System.out.println("===���Ǳ����α׷�===");
		
		java.util.Scanner input =
				new java.util.Scanner(System.in);
		
		//Ŀ������
		int price = 300;
		//Ŀ�� �ֹ��� �Һ�Ǵ� ��
		int content_coffe = 5;
		int content_cream = 3;
		int content_sugar = 1;
		
		//Ŀ�ǿ� �� ����� ���� ������
		int coffee = 10;
		int cream = 10;
		int sugar = 10;
		
		//�����ݾ�
		int amount = 0;
		
		//��������
		int coin = 1000;
		
		while(true) {
			System.out.print("1:Ŀ�Ǹ��ñ�,2:����>");
			int num = input.nextInt();
			
			if(num==1) {
				System.out.print("���� ����>");
				int payment = input.nextInt();
				
				//�Ž�����
				int change = payment-price;
				
				//Ŀ��,����,���� üũ
				
				//�Ž����� ���� ���� üũ
				if(coin < change) {
					System.out.println("�Ž����� ����!");
					continue;
				}
				
				//Ŀ��,����,���� ����
				
				//�Ž����� ����
				coin -= change;
				//������ �ݾ� ����
				amount += payment;
				
				//�Ž����� ���
				System.out.println("�Ž����� : " + change);
				System.out.println(
						"�� ���� Ŀ�ǰ� �غ�Ǿ����ϴ�.");
				
				System.out.println("===���� ���Ǳ� ����===");
				//Ŀ��,����,���� ������ ���
				System.out.println("���������ݾ� : " + coin);
				System.out.println("������ �ݾ� : " + amount);
				System.out.println("=====================");
				
			}else if(num==2) {
				System.out.println("���Ǳ� ���α׷� ����");
				break;
			}else {
				System.out.println("�߸��Է��߽��ϴ�.");
			}
		}
		
	}
}




