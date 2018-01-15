package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String process() {
		
		return "index"; //tiles�� ����� ��� index.jsp�� �ƴ϶� tiles ������ �ĺ�����
	}
}
