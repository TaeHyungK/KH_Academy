package com.jdbc.s07;

import java.sql.Date;

public class Score {
	//테이블의 row 에 대응 시키기 위한 클래스
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int avg;
	private String grade;
	private Date reg_date;
	
	//총점 메소드
	public int makeSum() {
		return kor+eng+math;
	}
	
	//평균 메소드
	public int makeAvg() {
		return makeSum()/3;
	}
	//등급 메소드
	public String makeGrade() {
		switch(makeAvg()/10){
			case 10:
			case 9: grade="A";break;
			case 8: grade="B";break;
			case 7: grade="C";break;
			case 6: grade="D";break;
			default: grade="F";
		}
		
		return grade;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
