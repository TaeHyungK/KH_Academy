
public class OperatorEx01 {
	public static void main(String[] args) {
		/*
		 * [실습]성적 처리 
		 * 국어(korean) 87 영어(english) 98 수학(math) 92
		 * 총점, 평균 구하기
		 * 
		 * 출력 예시
		 * -------
		 * 
		 * 국어 = 87
		 * 영어 = 98
		 * 수학 = 92
		 * 총점 = 
		 * 평균 = (소수점 둘째자리까지)
		 */
		int korean = 87, english = 98, math = 92;
		int sum = korean + english + math;
		double avg = (double)sum/3;
		//double avg = sum / 3.0; <- 자동 캐스팅

		System.out.printf("%s = %d\n", "국어", korean);
		System.out.printf("%s = %d\n", "영어", english);
		System.out.printf("%s = %d\n", "수학", math);
		System.out.printf("%s = %d\n", "총점", sum);
		System.out.printf("%s = %.2f\n", "평균", avg);
		
	}
}
