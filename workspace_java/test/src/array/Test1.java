package array;

public class Test1 {
	public static void main(String[] args) {
		int[][] array = {
				{12,41,36,56},
				{82,10,12,61},
				{14,16,18,78},
				{45,26,72,23}
		};

		double sum = 0;		
		double avg = 0.0;
		int divide = 0;

		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++){
				sum += array[i][j];
				divide++;
			}
		}

		avg = sum/divide;
		
		System.out.println("ÇÕ°è: " + sum);
		System.out.printf("Æò±Õ: %.3f", avg);
	}
}
