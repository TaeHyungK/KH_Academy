package kr.spring.finalp.domain;

import java.sql.Date;

public class ClassCommand {
	private int c_num;
	private int t_num;
	private int a_num;
	private String c_category;
	private String c_name;
	private String c_content;
	private int c_count;
	private int c_max_count;
	private Date c_start;
	private Date c_end;
	private int c_tuition;
	private Date c_regdate;
	private String m_id;
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
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
	public String getC_category() {
		return c_category;
	}
	public void setC_category(String c_category) {
		this.c_category = c_category;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public int getC_count() {
		return c_count;
	}
	public void setC_count(int c_count) {
		this.c_count = c_count;
	}
	public int getC_max_count() {
		return c_max_count;
	}
	public void setC_max_count(int c_max_count) {
		this.c_max_count = c_max_count;
	}
	public Date getC_start() {
		return c_start;
	}
	public void setC_start(Date c_start) {
		this.c_start = c_start;
	}
	public Date getC_end() {
		return c_end;
	}
	public void setC_end(Date c_end) {
		this.c_end = c_end;
	}
	public int getC_tuition() {
		return c_tuition;
	}
	public void setC_tuition(int c_tuition) {
		this.c_tuition = c_tuition;
	}
	public Date getC_regdate() {
		return c_regdate;
	}
	public void setC_regdate(Date c_regdate) {
		this.c_regdate = c_regdate;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	@Override
	public String toString() {
		return "ClassCommand [c_num=" + c_num + ", t_num=" + t_num + ", a_num=" + a_num + ", c_category=" + c_category
				+ ", c_name=" + c_name + ", c_content=" + c_content + ", c_count=" + c_count + ", c_max_count="
				+ c_max_count + ", c_start=" + c_start + ", c_end=" + c_end + ", c_tuition=" + c_tuition
				+ ", c_regdate=" + c_regdate + ", m_id=" + m_id + "]";
	}
	
	
	

}
