import java.util.Scanner;

public class DoWhileMain03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int kor, eng, math, sum;
		char grade;
		float avg;

		// 국어입력
		do {
			System.out.print("국어: ");
			kor = input.nextInt();
		} while (kor < 0 || kor > 100);
		// 영어입력
		do {
			System.out.print("영어: ");
			eng = input.nextInt();
		} while (eng < 0 || eng > 100);
		// 수학입력
		do {
			System.out.print("수학: ");
			math = input.nextInt();
		} while (math < 0 || math > 100);

		sum = kor + eng + math;
		avg = sum / 3.0f;

		switch ((int) (avg / 10)) {
		case 10: case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
		}
		
		System.out.println();
		System.out.printf("총점: %d점\n", sum);
		System.out.printf("평균: %.2f점\n", avg);
		System.out.println("학점: " + grade);
	}
}
