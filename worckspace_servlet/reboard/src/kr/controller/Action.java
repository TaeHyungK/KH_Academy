package kr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//추상메서드
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}









