import java.util.Scanner;

public class WhileMain07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//�ܰ�
		int balance =0;
		
		while(true) {
			System.out.println("-----------------------------------");
			System.out.println("1. ���� | 2. ��� | 3. �ܰ�Ȯ�� | 4. ����");
			System.out.println("-----------------------------------");
			System.out.print("��ȣ ����> ");
			
			//������ ��ȣ
			int num = input.nextInt();
			
			if(num==1) {//�Ա�
				System.out.print("���ݾ�> ");
				balance += input.nextInt();
			}else if(num==2) {//���
				System.out.print("��ݾ�> ");
				balance -= input.nextInt();
			}else if(num==3) {//�ܰ�Ȯ��
				System.out.printf("�ܰ�: %,d��\n", balance);
			}else if(num==4) {
				System.out.println("���α׷� ����");
				break;
			}else {
				System.out.println("�߸� �Է��߽��ϴ�.");
			}
			
		}
		
	}
}
