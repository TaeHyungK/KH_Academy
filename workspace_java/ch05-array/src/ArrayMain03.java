
public class ArrayMain03 {
	public static void main(String[] args) {
		int sum=0; // ÃÑÁ¡
		float avg= 0.0f;// Æò±Õ
		int[] score = {100,80,88,100,90};
		
		//ÃÑÁ¡
		for(int i=0;i<score.length;i++) {
			sum += score[i];
		}
		//Æò±Õ(¼Ò¼öÁ¡ µÑÂ°ÀÚ¸®±îÁö)
		avg = sum/(float)score.length;

		System.out.println("ÃÑÁ¡: " + sum);
		System.out.printf("Æò±Õ: %.2f", avg);
	}
}
