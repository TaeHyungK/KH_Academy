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
		num = 3; // �����
	}

	// ������ �����ε�
	public ScoreMain(int k, int m, int e, int h, int s) {
		kor = k;
		math = m;
		eng = e;
		history = h;
		science = s;
		num = 5;
	}

	// �հ� ���ϴ� �޼ҵ�
	public int getTotal() {
		int total;
		if (num == 5) {
			total = kor + eng + math;
		}else{
			total = kor + eng + math + history + science;
		}
		
		return total;
	}
	
	//��� ���ϴ� �޼ҵ�
	public int getAvg() {
		return getTotal()/num;
	}

	public static void main(String[] args) {
		ScoreMain sm = new ScoreMain(89, 92, 99);
		System.out.println("�հ� = " + sm.getTotal());
		System.out.println("��� = " + sm.getAvg());
		
		System.out.println("----------");
		
		ScoreMain sm2 = new ScoreMain(93, 88, 91, 79, 88);
		System.out.println("�հ� = " + sm2.getTotal());
		System.out.println("��� = " + sm2.getAvg());
				
	}
}




