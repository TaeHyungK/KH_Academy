import java.util.Scanner;

public class DoWhileMain03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int kor, eng, math, sum;
		char grade;
		float avg;

		// �����Է�
		do {
			System.out.print("����: ");
			kor = input.nextInt();
		} while (kor < 0 || kor > 100);
		// �����Է�
		do {
			System.out.print("����: ");
			eng = input.nextInt();
		} while (eng < 0 || eng > 100);
		// �����Է�
		do {
			System.out.print("����: ");
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
		System.out.printf("����: %d��\n", sum);
		System.out.printf("���: %.2f��\n", avg);
		System.out.println("����: " + grade);
	}
}
