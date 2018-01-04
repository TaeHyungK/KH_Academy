package kr.spring.ch02.annot;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.spring.product.Product;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnot.xml");
		
		Product p = (Product)context.getBean("product");
		p.launch();
		
		context.close();
	}
}
