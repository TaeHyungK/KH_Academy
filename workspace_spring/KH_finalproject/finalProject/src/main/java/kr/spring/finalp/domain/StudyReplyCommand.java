package kr.spring.finalp.domain;

import java.sql.Date;

public class StudyReplyCommand {
	private int sc_num;
	private int sb_num;
	private String sc_content;
	private Date sc_regdate;
	private int m_num;
	
	private String m_id;

	public int getSc_num() {
		return sc_num;
	}

	public void setSc_num(int sc_num) {
		this.sc_num = sc_num;
	}

	public int getSb_num() {
		return sb_num;
	}

	public void setSb_num(int sb_num) {
		this.sb_num = sb_num;
	}

	public String getSc_content() {
		return sc_content;
	}

	public void setSc_content(String sc_content) {
		this.sc_content = sc_content;
	}

	public Date getSc_regdate() {
		return sc_regdate;
	}

	public void setSc_regdate(Date sc_regdate) {
		this.sc_regdate = sc_regdate;
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

	@Override
	public String toString() {
		return "StudyReplyCommand [sc_num=" + sc_num + ", sb_num=" + sb_num + ", sc_content=" + sc_content
				+ ", sc_regdate=" + sc_regdate + ", m_num=" + m_num + ", m_id=" + m_id + "]";
	}
	
	
}
