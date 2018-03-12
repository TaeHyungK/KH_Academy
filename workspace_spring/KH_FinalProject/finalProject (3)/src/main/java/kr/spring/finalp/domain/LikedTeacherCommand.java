package kr.spring.finalp.domain;

public class LikedTeacherCommand {
	private int t_num;
	private int m_num;
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	@Override
	public String toString() {
		return "LikedTeacherCommand [t_num=" + t_num + ", m_num=" + m_num + "]";
	}
	
	
}
