package kr.spring.ch05;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class HomeController2 {
	private Camera camera;

	@Resource(name="camera5")
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init메소드 동작");
	}
	@PreDestroy
	public void close() {
		System.out.println("closw 메소드 동작");
	}
	
}
