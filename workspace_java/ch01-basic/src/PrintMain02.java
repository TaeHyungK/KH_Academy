
public class PrintMain02 {
	public static void main(String[] args) {
		/*
		 * System.out.printf()�� �̿��� ���
		 * �������� ������ ǥ���� �� �ִ� ���� ���� ����
		 * JDK5.0 �̻� ���� ��� ����
		 * 
		 * System.out.printf(���˹���, ������)
		 */
		
		//����
		//               ���˹���, ������
		System.out.printf("%c\n", 'A');
		//��6�ڸ� Ȯ�� �����ʿ� ����
		System.out.printf("%6c\n", 'B');
		//��6�ڸ� Ȯ�� ���ʿ� ����
		System.out.printf("%-6c\n", 'C');
		
		System.out.println("------------");
		
		//����
		System.out.printf("%d\n", 67);
		//��3�ڸ� ������ ��ǥ ǥ��
		System.out.printf("%,d��\n", 10000000);
		//5�ڸ��� ��� �����ʺ��� ǥ��
		System.out.printf("%5d\n", 20);
		//5�ڸ��� ��� ���ʺ��� ǥ��
		System.out.printf("%-5d\n", 20);
		//5�ڸ��� ��� �����ʺ��� ��ĭ�� 0���� ä���
		System.out.printf("%05d\n", 20);
		
		System.out.println("------------");
		
		//8����
		System.out.printf("%o\n", 17);
		//16����
		System.out.printf("%x\n", 20);

		System.out.println("------------");
		
		//�Ǽ�
		//�⺻ �Ҽ��� �ڸ�: 6�ڸ�, ��ĭ�� 0���� ǥ��
		System.out.printf("%f%n", 35.896);
		//�ټҼ��� ��°�ڸ����� ��� , �Ҽ��� ���� ���� �ڸ��� �ݿø�
		System.out.printf("%.2f%n", 23000.879);

		System.out.println("------------");
		
		//���ڿ�
		System.out.printf("%s%n", "����");
	
		//���ڿ��� ����
		System.out.printf("%s�� %d���Դϴ�.%n", "����", 98);

		System.out.println("------------");
	
		//����
		System.out.printf("%b%n", true);
		System.out.printf("%b%n", false);
		
		
	}
}
