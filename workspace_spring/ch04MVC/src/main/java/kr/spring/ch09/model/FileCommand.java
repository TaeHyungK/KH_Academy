package kr.spring.ch09.model;

import org.springframework.web.multipart.MultipartFile;

public class FileCommand {
	private String subject;
	
	private MultipartFile filename1;
	private MultipartFile filename2;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public MultipartFile getFilename1() {
		return filename1;
	}
	public void setFilename1(MultipartFile filename1) {
		this.filename1 = filename1;
	}
	public MultipartFile getFilename2() {
		return filename2;
	}
	public void setFilename2(MultipartFile filename2) {
		this.filename2 = filename2;
	}
	
			
}
