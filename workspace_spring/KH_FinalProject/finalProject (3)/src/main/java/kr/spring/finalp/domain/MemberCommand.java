package kr.spring.finalp.domain;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberCommand {
   private int m_num;
   private int m_group;
   @NotEmpty
   private String m_id;
   @NotEmpty
   @Size(min=4,max=10)
   private String m_pw;
   @NotEmpty
   private String m_name;
   @NotEmpty
   private String m_phone;
   @NotEmpty
   @Email
   private String m_email;
   @NotEmpty
   private String m_address; 
   private Date m_regdate;
   
   
   public boolean isCheckedPasswd(String userPasswd) {
      if(m_group>0 && m_pw.equals(userPasswd)) {
         System.out.println("userPasswd"+userPasswd);
         System.out.println("group"+m_group);
         return true;
      } 
      return false;
   }

   
   public int getM_num() {
      return m_num;
   }
   public void setM_num(int m_num) {
      this.m_num = m_num;
   }
   
   public int getM_group() {
      return m_group;
   }


   public void setM_group(int m_group) {
      this.m_group = m_group;
   }


   public String getM_id() {
      return m_id;
   }
   public void setM_id(String m_id) {
      this.m_id = m_id;
   }
   public String getM_pw() {
      return m_pw;
   }
   public void setM_pw(String m_pw) {
      this.m_pw = m_pw;
   }
   public String getM_name() {
      return m_name;
   }
   public void setM_name(String m_name) {
      this.m_name = m_name;
   }
   public String getM_phone() {
      return m_phone;
   }
   public void setM_phone(String m_phone) {
      this.m_phone = m_phone;
   }
   public String getM_email() {
      return m_email;
   }
   public void setM_email(String m_email) {
      this.m_email = m_email;
   }
   public String getM_address() {
      return m_address;
   }
   public void setM_address(String m_address) {
      this.m_address = m_address;
   }
   public Date getM_regdate() {
      return m_regdate;
   }
   public void setM_regdate(Date m_regdate) {
      this.m_regdate = m_regdate;
   }
   @Override
   public String toString() {
      return "MemberCommand [m_num=" + m_num + ", m_group=" + m_group + ", m_id=" + m_id + ", m_pw=" + m_pw
            + ", m_name=" + m_name + ", m_phone=" + m_phone + ", m_email=" + m_email + ", m_address=" + m_address
            + ", m_regdate=" + m_regdate + "]";
   }


}