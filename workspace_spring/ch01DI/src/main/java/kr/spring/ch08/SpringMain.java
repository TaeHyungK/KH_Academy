package kr.spring.ch08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//싱글턴 패턴
		ParserFactory parser = (ParserFactory) context.getBean("parser");
		System.out.println(parser);
		
		ParserFactory parser2 = (ParserFactory) context.getBean("parser2");
		System.out.println(parser2);
				
		context.close();
	}
}
