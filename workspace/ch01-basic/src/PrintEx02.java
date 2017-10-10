
public class PrintEx02 {
	public static void main(String[] args) {
		/*
		 * [실습]printf를 이용해서 아래와 같이 출력하시오.
		 * ---------출력예시--------
		 * 
		 * 국어 = 89점
		 * 영어 = 97점
		 * 총점 = 195점
		 * 평균 = 97.5점
		 * 
		 */

		System.out.printf("%s = %d점\n", "국어", 100);
		System.out.printf("%s = %d점\n", "영어", 95);
		System.out.printf("%s = %d점\n", "총점", 195);
		System.out.printf("%s = %.1f점\n", "평균", 97.5);
			
	}
}
