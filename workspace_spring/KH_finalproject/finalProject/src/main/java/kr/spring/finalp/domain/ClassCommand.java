package kr.spring.finalp.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ClassCommand {
	private int c_num;
	private int t_num;
	private int a_num;
	private String c_category;
	private String c_name;
	private String c_content;
	private int c_count;
	private int c_max_count;
	private Date c_start;
	private Date c_end;
	private int c_tuition;
	private Date c_regdate;
	private String m_id;
	private int m_num;
	private int my_num;
	
	private String t_name;
	
	private int total_price;
	
	private byte[] uploadfile;
	private String a_logo;
	
	private String a_name;
	
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public String getC_category() {
		return c_category;
	}
	public void setC_category(String c_category) {
		this.c_category = c_category;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public int getC_count() {
		return c_count;
	}
	public void setC_count(int c_count) {
		this.c_count = c_count;
	}
	public int getC_max_count() {
		return c_max_count;
	}
	public void setC_max_count(int c_max_count) {
		this.c_max_count = c_max_count;
	}
	public Date getC_start() {
		return c_start;
	}
	public void setC_start(Date c_start) {
		this.c_start = c_start;
	}
	public Date getC_end() {
		return c_end;
	}
	public void setC_end(Date c_end) {
		this.c_end = c_end;
	}
	public int getC_tuition() {
		return c_tuition;
	}
	public void setC_tuition(int c_tuition) {
		this.c_tuition = c_tuition;
	}
	public Date getC_regdate() {
		return c_regdate;
	}
	public void setC_regdate(Date c_regdate) {
		this.c_regdate = c_regdate;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	
	public int getMy_num() {
		return my_num;
	}
	public void setMy_num(int my_num) {
		this.my_num = my_num;
	}
	
	
	
	public byte[] getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(byte[] uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getA_logo() {
		return a_logo;
	}
	public void setA_logo(String a_logo) {
		this.a_logo = a_logo;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	
	@Override
	public String toString() {
		return "ClassCommand [c_num=" + c_num + ", t_num=" + t_num + ", a_num=" + a_num + ", c_category=" + c_category
				+ ", c_name=" + c_name + ", c_content=" + c_content + ", c_count=" + c_count + ", c_max_count="
				+ c_max_count + ", c_start=" + c_start + ", c_end=" + c_end + ", c_tuition=" + c_tuition
				+ ", c_regdate=" + c_regdate + ", m_id=" + m_id + ", m_num=" + m_num + ", my_num=" + my_num
				+ ", t_name=" + t_name + ", a_logo=" + a_logo + ", total_price=" + total_price + "]";
	}

	
	
	
	
	

}
