package kr.spring.ch09;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//List 타입 프로퍼티 설정
		PerformanceMonitor performanceMonitor = (PerformanceMonitor) context.getBean("performanceMonitor");
		System.out.println(performanceMonitor);
		
		context.close();
	}
}
