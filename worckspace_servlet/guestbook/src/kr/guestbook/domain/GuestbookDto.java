package kr.guestbook.domain;

import java.sql.Date;

//자바빈(DTO : Data Transfer Object)
public class GuestbookDto {
	//프로퍼티
	private int num;
	private String name;
	private String passwd;
	private String email;
	private String content;
	private Date register;
	
	//비밀번호 체크
	public boolean isCheckedPasswd(String userPasswd) {
		if(passwd.equals(userPasswd)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegister() {
		return register;
	}
	public void setRegister(Date register) {
		this.register = register;
	}
	

}
