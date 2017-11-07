import java.util.Scanner;

public class Test13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[] score = new int[4];
		int sum=0;
		double avg;

		System.out.print("컴퓨터 개론 점수: ");
		score[0] = input.nextInt();
		System.out.print("영어 개론 점수: ");
		score[1] = input.nextInt();
		System.out.print("일반수학 개론 점수: ");
		score[2] = input.nextInt();
		System.out.print("자바 개론 점수: ");
		score[3] = input.nextInt();
		
		for(int i=0;i<score.length;i++) {
			sum += score[i];
		}
		
		avg = (double)sum/(score.length);
		
		System.out.println("총점: " + sum);
		System.out.printf("평점: %.2f", avg);
	}
}
