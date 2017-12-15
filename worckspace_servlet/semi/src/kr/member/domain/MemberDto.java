package kr.member.domain;

public class MemberDto {
	private String id;
	private String passwd;
	private String name;
	private String phone;
	private String sex;
	private String card_num;
	
	//비밀번호 일치 여부 체크	
	public boolean isCheckePasswd(String userPasswd) {
		if(passwd.equals(userPasswd)) {
			return true;
		}
		
		return false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getSex() {
		return sex;
	}	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}


	
	
}
