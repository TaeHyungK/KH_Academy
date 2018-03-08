package kr.spring.finalp.domain;

import java.sql.Date;

public class InforReplyCommand {
	private int if_num;
	private int ib_num;
	private String ic_content;
	private Date ic_regdate;
	private int m_num;
	
	private String m_id;
	
	public int getIf_num() {
		return if_num;
	}
	public void setIf_num(int if_num) {
		this.if_num = if_num;
	}
	public int getIb_num() {
		return ib_num;
	}
	public void setIb_num(int ib_num) {
		this.ib_num = ib_num;
	}
	public String getIc_content() {
		return ic_content;
	}
	public void setIc_content(String ic_content) {
		this.ic_content = ic_content;
	}
	public Date getIc_regdate() {
		return ic_regdate;
	}
	public void setIc_regdate(Date ic_regdate) {
		this.ic_regdate = ic_regdate;
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
		return "InforReplyCommand [if_num=" + if_num + ", ib_num=" + ib_num + ", ic_content=" + ic_content
				+ ", ic_regdate=" + ic_regdate + ", m_num=" + m_num + ", m_id=" + m_id + "]";
	}
	
}
