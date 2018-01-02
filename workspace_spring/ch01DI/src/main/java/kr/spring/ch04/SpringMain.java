package kr.spring.ch04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
//		WriteArticleDao wad = new WriteArticleDao();
//		WriteArticleService was = new WriteArticleService(wad);
		/*
		 * applicationContext.xml 설정 파일을 읽어들여 스프링 컨테이너를 생성
		 * 설정파일에 명시한 클래스를 객체 생성해서 컨테이너에 보관
		 */
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//컨테이너에 DI(의존관계 주입) 생성자 설정 방식으로 생성된 객체를 읽어들임
		WriteArticleService articleService = (WriteArticleService) context.getBean("writeArticleService");
		//객체의 메소드 호출
		articleService.write();
		//어플리케이션 종료시 컨테이너에 존재하는 모든 빈 객체를 종료
		context.close();
		
	}
}
