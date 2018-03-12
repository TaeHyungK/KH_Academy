package kr.spring.finalp.domain;

import java.io.IOException;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class TeacherCommand {
   private int t_num;
   private int a_num;
   @NotEmpty
   private String t_name;
   @NotEmpty
   private String t_content;
   private String t_record;
   private String t_preview;
   private int t_good;
   private String m_id;
   
   private MultipartFile upload;
   private byte[] uploadfile;
   private String t_image;
   
   private int curNum;
   private int c_m_num;
   
   public void setUpload(MultipartFile upload) throws IOException{
      this.upload = upload;
      
      setUploadfile(upload.getBytes());
      setT_image(upload.getOriginalFilename());
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
   public String getT_name() {
      return t_name;
   }
   public void setT_name(String t_name) {
      this.t_name = t_name;
   }
   public String getT_content() {
      return t_content;
   }
   public void setT_content(String t_content) {
      this.t_content = t_content;
   }
   public String getT_record() {
      return t_record;
   }
   public void setT_record(String t_record) {
      this.t_record = t_record;
   }
   public String getT_preview() {
      return t_preview;
   }
   public void setT_preview(String t_preview) {
      this.t_preview = t_preview;
   }
   public int getT_good() {
      return t_good;
   }
   public void setT_good(int t_good) {
      this.t_good = t_good;
   }
   public String getM_id() {
      return m_id;
   }
   public void setM_id(String m_id) {
      this.m_id = m_id;
   }
   
   
   public MultipartFile getUpload() {
      return upload;
   }
   
   public byte[] getUploadfile() {
      return uploadfile;
   }
   public void setUploadfile(byte[] uploadfile) {
      this.uploadfile = uploadfile;
   }
   public String getT_image() {
      return t_image;
   }
   public void setT_image(String t_image) {
      this.t_image = t_image;
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

   @Override
   public String toString() {
      return "TeacherCommand [t_num=" + t_num + ", a_num=" + a_num + ", t_name=" + t_name + ", t_content=" + t_content
            + ", t_record=" + t_record + ", t_preview=" + t_preview + ", t_good=" + t_good + ", m_id=" + m_id
            + ", upload=" + upload + ", t_image=" + t_image + "]";
   }
   
   
   
   
   
   

}