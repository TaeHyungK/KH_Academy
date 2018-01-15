package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Menu2Controller {
	@RequestMapping("/menu2.do")
	public String process() {
		
		return "menu2"; //tiles를 사용할 경우 menu2.jsp가 아니라 tiles 설정의 식별자임
	}
}
