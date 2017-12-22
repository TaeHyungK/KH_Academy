package kr.qboard.domain;

import java.sql.Date;

public class QboardDto {
	private int q_num;
	private String q_title;
	private String q_content;
	private String q_id;
	private Date regdate;
	private String q_solve;
	
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_id() {
		return q_id;
	}
	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getQ_solve() {
		return q_solve;
	}
	public void setQ_solve(String q_solve) {
		this.q_solve = q_solve;
	}
	
	

}
