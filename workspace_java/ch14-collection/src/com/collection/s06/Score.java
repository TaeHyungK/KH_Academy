package com.collection.s06;

public class Score {
	private String name;
	private int kor;
	private int eng;
	private int math;

	//���� ���ϱ�
	public int makeSum() {
		return kor+eng+math;
	}

	//��� ���ϱ�
	public double makeAvg() {
		return (kor+eng+math)/3.0;
	}

	//���� ���ϱ�
	public String makeGrade() {
		String grade = "?";
		
		switch((int)this.makeAvg()/10) {
		case 10: case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6: 
			grade = "D";
			break;
		default:
			grade = "F";
		}

		return grade;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return name + "   " 
				+ kor + "   "
				+ eng + "   " 
				+ math + "   " 
				+ makeSum() + "   " 
				+ String.format("%.2f", makeAvg()) + "   " 
				+ makeGrade();
		
		}

}
