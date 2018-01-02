package kr.spring.ch10;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Map 타입 프로퍼티 설정
		ProtocolHandlerFactory protocolHandlerFactory = (ProtocolHandlerFactory) context.getBean("protocolHandlerFactory");
		System.out.println(protocolHandlerFactory);
		
		context.close();
	}
}
