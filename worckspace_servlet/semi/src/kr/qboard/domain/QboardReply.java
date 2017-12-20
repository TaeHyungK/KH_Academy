package kr.qboard.domain;

import java.sql.Date;

public class QboardReply {
	private int re_qnum;
	private String re_content;
	private Date re_date;
	private String q_id;
	public int getRe_qnum() {
		return re_qnum;
	}
	public void setRe_qnum(int re_qnum) {
		this.re_qnum = re_qnum;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	public String getQ_id() {
		return q_id;
	}
	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}
	
	

}
