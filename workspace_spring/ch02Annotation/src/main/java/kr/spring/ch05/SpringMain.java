package kr.spring.ch05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//@PostConstruct, @PreDestroy 어노테이션을 이용한 라이프 사이클 지정
		HomeController2 home = (HomeController2) context.getBean("homeController2");
		System.out.println(home);
		
		context.close();
	}
}
