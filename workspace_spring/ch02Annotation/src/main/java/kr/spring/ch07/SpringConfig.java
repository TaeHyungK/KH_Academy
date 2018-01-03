package kr.spring.ch07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	//@Bean 어노테이션을 명시함으로써 bean 객체를 설정
	@Bean
	public Worker worker() {
		return new Worker();
	}
	
	//명시한 메소드명이 생성된 빈의 이름(여기선 executor)
	@Bean
	public Executor executor() {
		Executor executor = new Executor();
		executor.setWorker(worker());
		return executor;
	}
}
