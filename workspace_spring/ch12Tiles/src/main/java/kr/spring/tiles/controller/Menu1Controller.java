package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Menu1Controller {
	@RequestMapping("/menu1.do")
	public String process() {
		
		return "menu1"; //tiles를 사용할 경우 menu1.jsp가 아니라 tiles 설정의 식별자임
	}
}
