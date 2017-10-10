
public class ArrayMain13 {
	public static void main(String[] args) {
		int[][] score = {{98,97,96}
						,{91,92,93}
						,{94,95,96}
						,{97,98,99}
						,{98,97,96}};
		
		System.out.println("번호 국어 영어 수학 총점 평균");
		System.out.println("--------------------");
		
		for(int i=0;i<score.length;i++) {
			int sum = 0;
			System.out.print(" "+(i+1)+" ");
			for(int j=0;j<score[i].length;j++) {
				sum += score[i][j];
				System.out.print(" "+ score[i][j]);
			}
			System.out.println(" "+ sum +  " " +sum/score[i].length);
		}
	}
}
