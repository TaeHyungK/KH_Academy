package com.instance.s04;

public class ScoreMain {
	int kor;
	int math;
	int eng;
	int history;
	int science;
	int num;

	public ScoreMain(int k, int m, int e) {
		kor = k;
		math = m;
		eng = e;
		num = 3; // 과목수
	}

	// 생성자 오버로딩
	public ScoreMain(int k, int m, int e, int h, int s) {
		kor = k;
		math = m;
		eng = e;
		history = h;
		science = s;
		num = 5;
	}

	// 합계 구하는 메소드
	public int getTotal() {
		int total;
		if (num == 5) {
			total = kor + eng + math;
		}else{
			total = kor + eng + math + history + science;
		}
		
		return total;
	}
	
	//평균 구하는 메소드
	public int getAvg() {
		return getTotal()/num;
	}

	public static void main(String[] args) {
		ScoreMain sm = new ScoreMain(89, 92, 99);
		System.out.println("합계 = " + sm.getTotal());
		System.out.println("평균 = " + sm.getAvg());
		
		System.out.println("----------");
		
		ScoreMain sm2 = new ScoreMain(93, 88, 91, 79, 88);
		System.out.println("합계 = " + sm2.getTotal());
		System.out.println("평균 = " + sm2.getAvg());
				
	}
}




