package kr.register_1.domain;

public class Register_1Dto {
	private String id;
	private String passwd;
	private String name;
	private int phone;
	private String sex;
	private int card_num;
	
	public boolean isCheckedPasswd(
		       String userPasswd) {
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getCard_num() {
		return card_num;
	}
	public void setCard_num(int card_num) {
		this.card_num = card_num;
	}

	@Override
	public String toString() {
		return "Register_1Dto [id=" + id + ", passwd=" + passwd + ", name=" + name + ", phone=" + phone + ", sex=" + sex
				+ ", card_num=" + card_num + "]";
	}
	
}
