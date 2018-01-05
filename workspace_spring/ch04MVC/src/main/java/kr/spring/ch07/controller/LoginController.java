package kr.spring.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch07.model.LoginCommand;
import kr.spring.ch07.validator.LoginCommandValidator;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {
	
	@RequestMapping(method= RequestMethod.GET)
	public String form() {
		return "login/form";
	}
	
	public String submit(LoginCommand loginCommand, BindingResult result) {
		System.out.println("데이터 전송 후 : " + loginCommand);

		//전송된 데이터에 대한 유효성 체크
		new LoginCommandValidator().validate(loginCommand, result);
		
		//BindingResult에 유효성 체크 결과 오류에 대한 내용이
		//저장되어 있으면 폼을 다시 호출함
		if(result.hasErrors()) {
			return form();
		}
		
		return "redirect:/index.jsp";
	}
}
