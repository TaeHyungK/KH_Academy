package kr.spring.ch07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		//자바코드 기반 설정
		Executor executor = (Executor) context.getBean("executor");
		executor.addUnit();
		
		context.close();
	}
}
