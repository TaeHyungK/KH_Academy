package kr.air.domain;

import java.sql.Date;

public class ReservationDto {
	private String id;
	private String start_lo;
	private String end_lo;
	private String ap_num;
	private String rsv_num;
	private Date regdate;
	

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStart_lo() {
		return start_lo;
	}
	public void setStart_lo(String start_lo) {
		this.start_lo = start_lo;
	}
	public String getEnd_lo() {
		return end_lo;
	}
	public void setEnd_lo(String end_lo) {
		this.end_lo = end_lo;
	}
	public String getAp_num() {
		return ap_num;
	}
	public void setAp_num(String ap_num) {
		this.ap_num = ap_num;
	}
	public String getRsv_num() {
		return rsv_num;
	}
	public void setRsv_num(String rsv_num) {
		this.rsv_num = rsv_num;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	
	
}
