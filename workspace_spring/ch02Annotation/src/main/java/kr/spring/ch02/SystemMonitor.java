package kr.spring.ch02;

import org.springframework.beans.factory.annotation.Autowired;

public class SystemMonitor {
	private int peroidTime;
	private SmsSender sender;
	
	public int getPeroidTime() {
		return peroidTime;
	}
	public void setPeroidTime(int peroidTime) {
		this.peroidTime = peroidTime;
	}
	public SmsSender getSender() {
		return sender;
	}
	/*
	 * @Autowired
	 * 생성자, 필드, 메소드에 지정 가능
	 * 메소드에 지정할 때는 setter메소드 뿐만 아니라 일반 메소드에도 적용 가능
	 * 
	 * @Autowired 어노테이션은 타입을 이용해서 자동적으로 프로퍼티 값을 설정하기 때문에,
	 * 해당 타입의 빈 객체가 존재하지 않거나 빈 객체가 2개 이상 존재할 경우 스프링은 @Autowired
	 * 어노테이션이 적용된 빈 객체를 생성할 때 예외가 발생
	 * 
	 * @Autowired의 기본값은 필수 여부도 체크
	 * @Autowired(required=false)로 지정하면 해당 타입의 빈 객체가 존재하지 않더라도 스프링은
	 * 예외를 발생하지 않음
	 */
	@Autowired
	public void setSender(SmsSender sender) {
		this.sender = sender;
	}
	
	
}
