package kr.air.domain;

import java.sql.Date;

public class AirDto {
	private int snum;
	private String id;
	private String start_lo;
	private String end_lo;
	private String ap_num;
	private String go_date;
	private String go_time;
	private String return_date;
	private String return_time;
	private	int adult;
	private int student;
	private int kid;
	private String take_time;
	private int seats;
	private int total_ticket;
	
	public int getTotal_ticket() {
		return total_ticket;
	}
	public void setTotal_ticket(int total_ticket) {
		this.total_ticket = total_ticket;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
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
	public String getGo_date() {
		return go_date;
	}
	public void setGo_date(String go_date) {
		this.go_date = go_date;
	}
	public String getGo_time() {
		return go_time;
	}
	public void setGo_time(String go_time) {
		this.go_time = go_time;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public String getReturn_time() {
		return return_time;
	}
	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getStudent() {
		return student;
	}
	public void setStudent(int student) {
		this.student = student;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getTake_time() {
		return take_time;
	}
	public void setTake_time(String take_time) {
		this.take_time = take_time;
	}
	@Override
	public String toString() {
		return "AirDto [snum=" + snum + ", id=" + id + ", start_lo=" + start_lo + ", end_lo=" + end_lo + ", ap_num="
				+ ap_num + ", go_date=" + go_date + ", go_time=" + go_time + ", return_date=" + return_date
				+ ", return_time=" + return_time + ", adult=" + adult + ", student=" + student + ", kid=" + kid
				+ ", take_time=" + take_time + "]";
	}
	
	
	
}
