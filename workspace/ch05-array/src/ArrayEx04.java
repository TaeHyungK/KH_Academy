
public class ArrayEx04 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�����]
		 * ��¿���
		 * ��ȣ ���� ���� ���� ���� ���
		 * 1   90 80 99
		 * 2   98 82 95
		 * score 2���� �迭�� �������� �հ�� ��� ���ϰ�
		 * ����� �Ҽ��� ��°�ڸ����� ǥ��
		 */
		int[][] score = {
				{90,80,99},
				{98,82,95},
				{91,82,94},
				{95,84,92}				
		};
		int sum = 0;
		int total=0;
		
		double avg = 0.0;
		double totalAvg =0.0;
		
		System.out.println("��ȣ\t����\t����\t����\t����\t���");
		
		for(int i=0; i<score.length;i++) {
			System.out.printf("%d\t", i+1);
			for(int j=0;j<score[i].length;j++) {
				System.out.printf("%d\t", score[i][j]);

				sum += score[i][j];
				avg = (double)sum/score[i].length;
				
				
			}
				
			System.out.printf("%d\t%.2f", sum, avg);
			System.out.println();
			total += sum;
			totalAvg += avg;
			
			sum = 0;
			avg = 0.0;
		}
		totalAvg = totalAvg/score.length;
		
		System.out.println("=================");
		System.out.println("�� �հ�: "+ total);
		System.out.printf("�� ���: %.2f",totalAvg);
		
	}
}
