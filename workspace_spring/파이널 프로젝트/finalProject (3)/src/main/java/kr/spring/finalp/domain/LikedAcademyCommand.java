package kr.spring.finalp.domain;

public class LikedAcademyCommand {
	private int m_num;
	private int a_num;
	
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	@Override
	public String toString() {
		return "LikedAcademyCommand [m_num=" + m_num + ", a_num=" + a_num + "]";
	}
	
	
}
