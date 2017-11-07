
public class ArrayMain04 {
	public static void main(String[] args) {
		int[] score = {79,88,91,33,100,55,95};
		
		//배열의 첫번째 값으로 최대값을 초기화
		int max =score[0];
		//배열의 첫번째값으로 최소값을 초기화
		int min = score[0];
		
		for(int i=1;i<score.length;i++) {
			//최대값
			if(score[i]>max)
				max = score[i];
			//최소값
			if(score[i]<min)
				min = score[i];
		}
		
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}
}
