package kr.spring.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		//뷰 이름 지정
		mav.setViewName("hello");
		//뷰에서 사용할 데이터 셋팅
		mav.addObject("greeting","안녕하세요!");
		
		return mav;
	}
}




