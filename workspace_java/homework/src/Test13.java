import java.util.Scanner;

public class Test13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[] score = new int[4];
		int sum=0;
		double avg;

		System.out.print("��ǻ�� ���� ����: ");
		score[0] = input.nextInt();
		System.out.print("���� ���� ����: ");
		score[1] = input.nextInt();
		System.out.print("�Ϲݼ��� ���� ����: ");
		score[2] = input.nextInt();
		System.out.print("�ڹ� ���� ����: ");
		score[3] = input.nextInt();
		
		for(int i=0;i<score.length;i++) {
			sum += score[i];
		}
		
		avg = (double)sum/(score.length);
		
		System.out.println("����: " + sum);
		System.out.printf("����: %.2f", avg);
	}
}
