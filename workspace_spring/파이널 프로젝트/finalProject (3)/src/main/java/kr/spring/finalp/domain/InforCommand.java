package kr.spring.finalp.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class InforCommand {
	private int ib_num;
	@NotEmpty
	private String ib_title;
	@NotEmpty
	private String ib_content;
	private int ib_hit;
	private Date ib_date;
	private int m_num;
	private String m_id;
	
	private int reply_cnt;


	public int getIb_num() {
		return ib_num;
	}


	public void setIb_num(int ib_num) {
		this.ib_num = ib_num;
	}


	public String getIb_title() {
		return ib_title;
	}


	public void setIb_title(String ib_title) {
		this.ib_title = ib_title;
	}


	public String getIb_content() {
		return ib_content;
	}


	public void setIb_content(String ib_content) {
		this.ib_content = ib_content;
	}


	public int getIb_hit() {
		return ib_hit;
	}


	public void setIb_hit(int ib_hit) {
		this.ib_hit = ib_hit;
	}


	public Date getIb_date() {
		return ib_date;
	}


	public void setIb_date(Date ib_date) {
		this.ib_date = ib_date;
	}


	public int getM_num() {
		return m_num;
	}


	public void setM_num(int m_num) {
		this.m_num = m_num;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public int getReply_cnt() {
		return reply_cnt;
	}


	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}


	@Override
	public String toString() {
		return "InforCommand [ib_num=" + ib_num + ", ib_title=" + ib_title + ", ib_content=" + ib_content + ", ib_hit="
				+ ib_hit + ", ib_date=" + ib_date + ", m_num=" + m_num + ", m_id=" + m_id + ", reply_cnt=" + reply_cnt
				+ "]";
	}

}
