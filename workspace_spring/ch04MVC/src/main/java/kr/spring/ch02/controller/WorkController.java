package kr.spring.ch02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkController {
	@RequestMapping("/work.do")
	public ModelAndView work() {
		ModelAndView mav = new ModelAndView();
		//뷰 이름 지정
		mav.setViewName("work");
		//뷰에서 사용할 데이터 셋팅
		mav.addObject("job", "프로그래밍을 열심히 하고있습니다.");
		return mav;
	}
}
