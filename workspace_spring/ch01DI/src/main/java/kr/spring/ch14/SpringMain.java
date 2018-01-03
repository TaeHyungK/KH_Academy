package kr.spring.ch14;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		//프로퍼티 타입을 이용한 의존 관계 자동 설정
		SystemMonitor monitor = (SystemMonitor) context.getBean("systemMonitor");
		System.out.println(monitor);
		
		context.close();
	}
}

