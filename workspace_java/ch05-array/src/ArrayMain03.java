
public class ArrayMain03 {
	public static void main(String[] args) {
		int sum=0; // ����
		float avg= 0.0f;// ���
		int[] score = {100,80,88,100,90};
		
		//����
		for(int i=0;i<score.length;i++) {
			sum += score[i];
		}
		//���(�Ҽ��� ��°�ڸ�����)
		avg = sum/(float)score.length;

		System.out.println("����: " + sum);
		System.out.printf("���: %.2f", avg);
	}
}
