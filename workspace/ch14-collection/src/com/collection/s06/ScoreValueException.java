package com.collection.s06;

//사용자 정의 예외 클래스
public class ScoreValueException extends Exception{
	public ScoreValueException(String message) {
		super(message);
	}
}
