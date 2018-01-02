package kr.spring.ch07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//DI 프로퍼티 설정 방식
		//XML 네임스페이스를 이용한 프로퍼티 설정
		SystemMonitor monitor = (SystemMonitor)context.getBean("monitor2");
		//객체의 메소드 호출
		System.out.println(monitor);
		
		context.close();
	}
}
