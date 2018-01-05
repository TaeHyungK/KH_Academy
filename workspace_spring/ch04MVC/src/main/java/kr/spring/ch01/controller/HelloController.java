package kr.spring.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		//�� �̸� ����
		mav.setViewName("hello"); //-> hello.jsp���� .jsp�� ������ ����, ViewResolver�� �ڵ����� �ٿ���
		//�信�� ����� ������ ����
		mav.addObject("greeting", "�ȳ��ϼ���!"); // request�� �����
		
		return mav;
	}
}
