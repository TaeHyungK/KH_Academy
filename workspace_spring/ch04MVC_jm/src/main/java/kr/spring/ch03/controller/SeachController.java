package kr.spring.ch03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeachController {
	
	@RequestMapping("/search/internal.do")
	/*
	 * @RequestMapping 어노테이션은 HTTP 요청 파라미터를 메서드의 파라미터로 전달
	 * query는 필수적으로 전달해야 하는 데이터이기 때문에 query 미전달시 오류
	 * @ReauestParam를 생략할 수 있음. 생략할 때는 메서드의 파라미터명과 요청 파라미터명이 일치해야 함.
	 * 요청 파라미터가 없어도 오류가 발생하지 않고  null값 반환
	 */
	public ModelAndView searchInternal(@RequestParam("query") String query,@RequestParam(value="p",defaultValue="1") int pageNumber) {
		System.out.println("query = " + query + ", pageNumber = " + pageNumber);
		
		return new ModelAndView("search/internal");
	}
	
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(@RequestParam(value="query", required=false) String query) {
		System.out.println("query = " + query);
		
		return new ModelAndView("search/external");
	}
	
}
