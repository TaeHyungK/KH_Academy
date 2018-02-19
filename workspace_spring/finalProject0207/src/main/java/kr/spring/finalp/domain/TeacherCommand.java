package kr.spring.finalp.domain;

public class TeacherCommand {
	private int t_num;
	private int a_num;
	private String t_name;
	private String t_content;
	private String t_record;
	private String t_preview;
	private int t_good;
	private String m_id;
	
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_content() {
		return t_content;
	}
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	public String getT_record() {
		return t_record;
	}
	public void setT_record(String t_record) {
		this.t_record = t_record;
	}
	public String getT_preview() {
		return t_preview;
	}
	public void setT_preview(String t_preview) {
		this.t_preview = t_preview;
	}
	public int getT_good() {
		return t_good;
	}
	public void setT_good(int t_good) {
		this.t_good = t_good;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	@Override
	public String toString() {
		return "TeacherCommand [t_num=" + t_num + ", a_num=" + a_num + ", t_name=" + t_name + ", t_content=" + t_content
				+ ", t_record=" + t_record + ", t_preview=" + t_preview + ", t_good=" + t_good + ", m_id=" + m_id + "]";
	}
	
	
	
	
	
	

}
