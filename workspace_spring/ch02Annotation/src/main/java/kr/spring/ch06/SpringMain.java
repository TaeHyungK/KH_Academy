package kr.spring.ch06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextScan.xml");
		
		//@Component 어노테이션을 클래스에 적용해서 자동 스캔된 빈 객체 호출
		HomeController home = (HomeController) context.getBean("homeController");
		System.out.println(home);
		
		context.close();
	}
}
