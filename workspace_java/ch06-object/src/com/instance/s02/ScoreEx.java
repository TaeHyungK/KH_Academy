package com.instance.s02;

import java.util.Scanner;

class Score {
	String name;
	int kor;
	int math;
	int eng;
	int sum;
	double avg;

	// ����(int�� ��ȯ)
	public int getSum(int a, int b, int c) {
		sum = a + b + c;
		return sum;
	}

	// ���(double�� ��ȯ)
	public double getAvg(int _sum) {
		avg = sum / 3.0;
		return avg;
	}

	// ����(char �� ��ȯ)
	public char getGrade(int average) {
		char grade;

		switch (average / 10) {
			case 10:
			case 9: 
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

		return grade;
	}

}

public class ScoreEx {
	public static void main(String[] args) {
		// ��ü ����
		Score score = new Score();

		Scanner input = new Scanner(System.in);
		// ���� �Է�
		System.out.print("���� �Է�: ");
		score.kor = input.nextInt();
		// ���� �Է�
		System.out.print("���� �Է�: ");
		score.math = input.nextInt();

		// ���� �Է�
		System.out.print("���� �Է�: ");
		score.eng = input.nextInt();

		// ����, ��� ���
		int score_sum = score.getSum(score.kor, score.math, score.eng);
		double score_avg = score.getAvg(score_sum);
		char score_grade = score.getGrade((int) score_avg);
		System.out.println("����: " + score_sum);
		System.out.printf("���: %.2f\n", score_avg);
		System.out.println("����: " + score_grade);
	}
}
