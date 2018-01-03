package kr.spring.ch03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SystemMonitor2 monitor = (SystemMonitor2) context.getBean("systemMonitor");
		System.out.println(monitor.getRecoder());
		
		context.close();
	}
}
