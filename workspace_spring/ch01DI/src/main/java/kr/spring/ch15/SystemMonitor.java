package kr.spring.ch15;

public class SystemMonitor {
	private long periodTime;
	private SmsSender sender;
	
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
	}
	public void setSender(SmsSender sender) {
		this.sender = sender;
	}
	@Override
	public String toString() {
		return "SystemMonitor [periodTime=" + periodTime + ", sender=" + sender + "]";
	}
	
	
}
