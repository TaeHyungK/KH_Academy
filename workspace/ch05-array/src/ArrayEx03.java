import java.util.Scanner;

public class ArrayEx03 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]�л��� ������ �Է��� �� 
		 * �ְ� ������ ��� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * 
		 */
		
		Scanner input = new Scanner(System.in);
		
		int[] scores = new int[3];
		
		while(true) {
			System.out.println("----------------------------------");
			System.out.println("1.�����Է� | 2.��������Ʈ | 3.�м� | 4.����");
			System.out.println("----------------------------------");
			
			System.out.print("��ȣ �Է�> ");
			int mode = input.nextInt();
			
			if(mode==1) {
				for(int i=0;i<scores.length;i++) {
					System.out.print((i+1)+"�� �л� ���� �Է�: ");
					scores[i] = input.nextInt();
				}
			}else if(mode==2) {
				for(int i=0;i<scores.length;i++) {
					System.out.println((i+1)+"�� �л� ����: "+scores[i]);
				}
				
//				System.out.println("�л� ���� : " + scores[0]);
//				System.out.println("�л� ���� : " + scores[1]);
//				System.out.println("�л� ���� : " + scores[2]);
			}else if(mode==3) {
				int max = scores[0];
				int sum = 0;
				double avg = 0;
				//�ְ� ���� ���ϱ�
				for(int i=1;i<scores.length;i++) {
					if(scores[i] > max)
						max = scores[i];
				}
				//��� ���� ���ϱ�
				for(int i=0;i<scores.length;i++) {
					sum += scores[i];
				}
				avg = sum/(double)scores.length;
				//�ְ� ����, ��� ���� ���
				System.out.println("�ְ� ����: " +max);
				System.out.printf("��� ����: %.2f\n",avg);
			}else if(mode==4) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}else {
				System.out.println("1~4�� �Է��Ͻÿ�.");
			}
		}
		
	}
}
