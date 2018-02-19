package kr.spring.finalp.domain;

import java.sql.Clob;
import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class AcademyCommand {
	private int a_num;
	private int m_num;
	@NotEmpty
	private String a_name;
	@NotEmpty
	private String a_location;
	@NotEmpty
	private String a_phone;
	@NotEmpty
	private String a_content;
	private int a_good; //¡¡æ∆ø‰(∑©≈∑)
	private int cp_num;
	private Date a_regdate;
	
	
	private String m_id;
	
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_location() {
		return a_location;
	}
	public void setA_location(String a_location) {
		this.a_location = a_location;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public int getA_good() {
		return a_good;
	}
	public void setA_good(int a_good) {
		this.a_good = a_good;
	}
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
	}

	public Date getA_regdate() {
		return a_regdate;
	}
	public void setA_regdate(Date a_regdate) {
		this.a_regdate = a_regdate;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	@Override
	public String toString() {
		return "AcademyCommand [a_num=" + a_num + ", m_num=" + m_num + ", a_name=" + a_name + ", a_location="
				+ a_location + ", a_phone=" + a_phone + ", a_content=" + a_content + ", a_good=" + a_good + ", cp_num="
				+ cp_num + ", a_regdate=" + a_regdate + ", m_id=" + m_id + "]";
	}

	
}
