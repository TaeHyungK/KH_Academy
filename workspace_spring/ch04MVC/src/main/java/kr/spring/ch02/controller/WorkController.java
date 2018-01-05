package kr.spring.ch02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkController {
	@RequestMapping("/work.do")
	public ModelAndView work() {
		ModelAndView mav = new ModelAndView();
		//�� �̸� ����
		mav.setViewName("work");
		//�信�� ����� ������ ����
		mav.addObject("job", "���α׷����� ������ �ϰ��ֽ��ϴ�.");
		return mav;
	}
}
