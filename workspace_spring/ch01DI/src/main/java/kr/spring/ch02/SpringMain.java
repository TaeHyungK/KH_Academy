package kr.spring.ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		/*
		 * applicationContext.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		 * 스프링 컨테이너를 생성
		 * 스프링 컨테이너가 생성되고 설정파일에 명시한 클래스를 객체 생성해서 컨테이너에 보관
		 */
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//객체를 컨테이너로부터 읽어들임
		StudentBean studentBean = (StudentBean)context.getBean("studentBean");
		//객체의 메소드 호출
		studentBean.study("국어");
		
		//어플리 케이션 종료시 컨테이너에 존재하는 모든 빈 객체를 종료
		context.close();
		
	}
}
