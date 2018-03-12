package kr.spring.finalp.domain;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.internal.Nullable;

public class AcademyCommand {
	private int a_num;
	private int m_num;
	@NotEmpty
	private String a_name;
	@NotEmpty
	private String a_location;
	@NotEmpty
	private String a_phone;
	@NotEmpty
	private String a_content;
	private int a_good; //좋아요(랭킹)
	@Nullable
	private int cp_num;
	private Date a_regdate;
	
	private MultipartFile upload;
	private byte[] uploadfile;
	private String a_logo;
	
	private int curNum;
	private int c_m_num; //좋아요 누른 회원번호 (l.m_num)
	
	private String m_id;
		
	public void setUpload(MultipartFile upload) throws IOException{
		this.upload = upload;
		
		//Multipart -> byte[]
		setUploadfile(upload.getBytes());
		//파일명 셋팅
		setA_logo(upload.getOriginalFilename());
	}
	
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_location() {
		return a_location;
	}
	public void setA_location(String a_location) {
		this.a_location = a_location;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public int getA_good() {
		return a_good;
	}
	public void setA_good(int a_good) {
		this.a_good = a_good;
	}
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
	}

	public Date getA_regdate() {
		return a_regdate;
	}
	public void setA_regdate(Date a_regdate) {
		this.a_regdate = a_regdate;
	}
	public String getA_logo() {
		return a_logo;
	}
	public void setA_logo(String a_logo) {
		this.a_logo = a_logo;
	}
	public byte[] getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(byte[] uploadfile) {
		this.uploadfile = uploadfile;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	
		
	public int getCurNum() {
		return curNum;
	}
	public void setCurNum(int curNum) {
		this.curNum = curNum;
	}
	
	public int getC_m_num() {
		return c_m_num;
	}

	public void setC_m_num(int c_m_num) {
		this.c_m_num = c_m_num;
	}
	
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	
	@Override
	public String toString() {
		return "AcademyCommand [a_num=" + a_num + ", m_num=" + m_num + ", a_name=" + a_name + ", a_location="
				+ a_location + ", a_phone=" + a_phone + ", a_content=" + a_content + ", a_good=" + a_good + ", cp_num="
				+ cp_num + ", a_regdate=" + a_regdate + ", upload=" + upload + ", a_logo=" + a_logo + ", curNum=" + curNum
				+ ", c_m_num=" + c_m_num + "]";
	}

	

	
}
