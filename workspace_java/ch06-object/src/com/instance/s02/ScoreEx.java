package com.instance.s02;

import java.util.Scanner;

class Score {
	String name;
	int kor;
	int math;
	int eng;
	int sum;
	double avg;

	// 총점(int값 반환)
	public int getSum(int a, int b, int c) {
		sum = a + b + c;
		return sum;
	}

	// 평균(double값 반환)
	public double getAvg(int _sum) {
		avg = sum / 3.0;
		return avg;
	}

	// 학점(char 값 반환)
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
		// 객체 생성
		Score score = new Score();

		Scanner input = new Scanner(System.in);
		// 국어 입력
		System.out.print("국어 입력: ");
		score.kor = input.nextInt();
		// 수학 입력
		System.out.print("수학 입력: ");
		score.math = input.nextInt();

		// 영어 입력
		System.out.print("영어 입력: ");
		score.eng = input.nextInt();

		// 총점, 평균 출력
		int score_sum = score.getSum(score.kor, score.math, score.eng);
		double score_avg = score.getAvg(score_sum);
		char score_grade = score.getGrade((int) score_avg);
		System.out.println("총점: " + score_sum);
		System.out.printf("평균: %.2f\n", score_avg);
		System.out.println("학점: " + score_grade);
	}
}
