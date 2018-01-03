package kr.spring.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Camera camera = (Camera) context.getBean("camera1");
		System.out.println(camera);
		
		context.close();
	}
}
