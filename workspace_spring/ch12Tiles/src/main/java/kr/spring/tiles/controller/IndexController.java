package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String process() {
		
		return "index"; //tiles를 사용할 경우 index.jsp가 아니라 tiles 설정의 식별자임
	}
}
