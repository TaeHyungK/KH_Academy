package kr.spring.ch15;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		//부모빈을 통한 설정 재사용
		SystemMonitor monitor = (SystemMonitor) context.getBean("doorMonitor");
		System.out.println(monitor);
		
		SystemMonitor monitor2 = (SystemMonitor) context.getBean("lobbyMonitor");
		System.out.println(monitor2);
				
		SystemMonitor monitor3 = (SystemMonitor) context.getBean("roomMonitor");
		System.out.println(monitor3);
		
		context.close();
	}
}
