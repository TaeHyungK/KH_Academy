
public class ArrayMain04 {
	public static void main(String[] args) {
		int[] score = {79,88,91,33,100,55,95};
		
		//�迭�� ù��° ������ �ִ밪�� �ʱ�ȭ
		int max =score[0];
		//�迭�� ù��°������ �ּҰ��� �ʱ�ȭ
		int min = score[0];
		
		for(int i=1;i<score.length;i++) {
			//�ִ밪
			if(score[i]>max)
				max = score[i];
			//�ּҰ�
			if(score[i]<min)
				min = score[i];
		}
		
		System.out.println("�ִ밪: " + max);
		System.out.println("�ּҰ�: " + min);
	}
}
