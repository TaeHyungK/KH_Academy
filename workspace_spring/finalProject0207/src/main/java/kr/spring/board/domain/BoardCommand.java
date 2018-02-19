package kr.spring.board.domain;

import java.io.IOException;
import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class BoardCommand {
	private int num;
	@NotEmpty
	private String title;
	@NotEmpty
	private String content;
	private int hit;
	private Date regdate;
	private MultipartFile upload;//blob��Ÿ�Ϸ� db�� ������ �ÿ��� ����Ʈ �迭�� ���� ���� ����
	private byte[] uploadfile;//MultipartFile�� ����� ������ ����Ʈ �迭�� ���� *toString ���� �ÿ��� ���� ���
	private String filename;
	private String ip;
	@NotEmpty
	private String id;
	
	private int reply_cnt;
	
	public void setUpload(MultipartFile upload) throws IOException{
		this.upload = upload;
		
		//MultipartFile -> byte[]
		setUploadfile(upload.getBytes());
		//���ϸ� ����
		setFilename(upload.getOriginalFilename());
		
	}

	public int getReply_cnt() {
		return reply_cnt;
	}

	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/*����*/
	//byte[] Ÿ���� ������(����)�� ����(uploadfile)
	@Override
	public String toString() {
		return "BoardCommand [num=" + num + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regdate="
				+ regdate + ", upload=" + upload + ", filename=" + filename + ", ip=" + ip + ", id=" + id + ", reply_cnt="+ reply_cnt +"]";
	}
	
}
