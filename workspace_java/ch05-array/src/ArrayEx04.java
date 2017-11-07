
public class ArrayEx04 {
	public static void main(String[] args) {
		/*
		 * [실습문제]
		 * 출력예시
		 * 번호 국어 영어 수학 총점 평균
		 * 1   90 80 99
		 * 2   98 82 95
		 * score 2차원 배열의 대이터의 합계와 평균 구하고
		 * 평균은 소수점 둘째자리까지 표시
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
		
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		
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
		System.out.println("총 합계: "+ total);
		System.out.printf("총 평균: %.2f",totalAvg);
		
	}
}
