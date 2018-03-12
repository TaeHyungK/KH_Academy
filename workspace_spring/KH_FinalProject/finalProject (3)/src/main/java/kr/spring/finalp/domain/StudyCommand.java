package kr.spring.finalp.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class StudyCommand {
	private int sb_num;
	@NotEmpty
	private String sb_title;
	@NotEmpty
	private String sb_content;
	private int sb_hit;
	private int sb_count;
	private Date sb_date;
	private int m_num;
	
	private String m_id;
	
	private int reply_cnt;

	public int getSb_num() {
		return sb_num;
	}

	public void setSb_num(int sb_num) {
		this.sb_num = sb_num;
	}

	public String getSb_title() {
		return sb_title;
	}

	public void setSb_title(String sb_title) {
		this.sb_title = sb_title;
	}

	public String getSb_content() {
		return sb_content;
	}

	public void setSb_content(String sb_content) {
		this.sb_content = sb_content;
	}

	public int getSb_hit() {
		return sb_hit;
	}

	public void setSb_hit(int sb_hit) {
		this.sb_hit = sb_hit;
	}

	public int getSb_count() {
		return sb_count;
	}

	public void setSb_count(int sb_count) {
		this.sb_count = sb_count;
	}

	public Date getSb_date() {
		return sb_date;
	}

	public void setSb_date(Date sb_date) {
		this.sb_date = sb_date;
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
		return "StudyCommand [sb_num=" + sb_num + ", sb_title=" + sb_title + ", sb_content=" + sb_content + ", sb_hit="
				+ sb_hit + ", sb_count=" + sb_count + ", sb_date=" + sb_date + ", m_num=" + m_num + ", m_id=" + m_id
				+ ", reply_cnt=" + reply_cnt + "]";
	}
	
	
}
