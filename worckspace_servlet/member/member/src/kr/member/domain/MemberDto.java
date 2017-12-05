package kr.member.domain;

import java.sql.Date;

//�ڹٺ� (DTO : Data Transfer Object) ������ �ӽ� ����
public class MemberDto {
    //������Ƽ
	private String id;
	private String name;
	private String passwd;
	private String email;
	private String phone;
	private Date reg_date;
	
	//��й�ȣ üũ
	public boolean isCheckedPasswd(String userPasswd) {
		if(passwd.equals(userPasswd)){//��й�ȣ ��ġ
			return true;
		}else {
			return false;
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}