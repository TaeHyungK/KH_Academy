package my.member.domain;

import java.sql.Date;

public class MemberDto {
   
   private String id;
   private String name;
   private String passwd;
   private String email;
   private String phone;
   private String zipcode;
   private String address;
   private Date reg_date;
   
   //비밀번호 체크
   public boolean isCheckedPasswd(String userPasswd) {
	   if(passwd.equals(userPasswd)) {//비밀번호 일치
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
   public String getZipcode() {
      return zipcode;
   }
   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public Date getReg_date() {
      return reg_date;
   }
   public void setReg_date(Date reg_date) {
      this.reg_date = reg_date;
   }
   
}