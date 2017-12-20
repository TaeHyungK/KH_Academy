package kr.air.domain;

import java.sql.Date;

public class ReservationDto {
	private String id;
	private String departure;
	private String destination;
	private String ap_num;
	private String rsv_num;
	private Date regdate;
	

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
