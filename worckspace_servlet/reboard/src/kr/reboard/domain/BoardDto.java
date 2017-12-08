package kr.reboard.domain;

import java.sql.Date;

public class BoardDto {
	private int num;
	private String title;
	private String content;
	private int hit;
	private Date regdate;
	private String ip;
	private String id;
	private int reply_cnt; //´ñ±Û¼ö
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getReply_cnt() {
		return reply_cnt;
	}
	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}
	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regdate="
				+ regdate + ", ip=" + ip + ", id=" + id + ", reply_cnt=" + reply_cnt + "]";
	}
}









