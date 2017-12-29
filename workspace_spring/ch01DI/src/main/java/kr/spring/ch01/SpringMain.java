package kr.spring.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		/*
		 * applicationContext.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		 * 이때 applicationContext에 명시한 클래스가 객체 생성이 되어 스프링 컨테이너에 보관됨
		 */
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//객체를 컨테이너로부터 읽어들임
		MessageBean messageBean = (MessageBean)context.getBean("messageBean");
		//객체의 메소드 호출
		messageBean.sayHello("홍길동");
		
		//어플리케이션 종료시 컨테이너에 존재하는 모든 객체를 제거(자원정리)
		context.close();
		
	}
}
