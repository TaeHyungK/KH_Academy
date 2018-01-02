package kr.spring.ch05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		/*
		 * applicationContext.xml 설정 파일을 읽어들여 스프링 컨테이너를 생성
		 * 설정파일에 명시한 클래스를 객체 생성해서 컨테이너에 보관
		 */
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//DI(의존관계 주입) 설정, 생성자 방식 설정
		SystemMonitor monitor = (SystemMonitor) context.getBean("monitor");
		System.out.println(monitor);
		
		context.close();
		
	}
}
