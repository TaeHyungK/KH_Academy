package kr.spring.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SystemMonitor2 {
	@Autowired
	@Qualifier("main")
	private Recorder recoder;

	public Recorder getRecoder() {
		return recoder;
	}

	public void setRecoder(Recorder recoder) {
		this.recoder = recoder;
	}
		
}
