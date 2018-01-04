package kr.spring.ch01.pojo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.spring.product.Product;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//핵심 로직이 있는 객체 호출
		Product p = (Product)context.getBean("product");
		//객체의 메서드 호출
		p.launch();
		
		context.close();
	}
}
