package kr.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardListController {
	
	@RequestMapping("/board/list.do")
	public ModelAndView process() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList");
		
		return mav;
	}
}
