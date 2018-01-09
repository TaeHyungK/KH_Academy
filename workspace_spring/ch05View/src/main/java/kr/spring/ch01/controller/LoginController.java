package kr.spring.ch01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch01.model.LoginCommand;
import kr.spring.ch01.service.LoginService;
import kr.spring.ch01.validator.LoginCommandValidator;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ
	@ModelAttribute("login")
	public LoginCommand initCommand() {
		return new LoginCommand();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "loginForm";
	}
	  
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("login") LoginCommand loginCommand, BindingResult result) {
		//��ȿ�� üũ
		new LoginCommandValidator().validate(loginCommand, result);
		if(result.hasErrors()) {
			return form();
		}
		
		//�α��� üũ
		try {
			loginService.checkAuth(loginCommand);
			return "loginSuccess";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			result.reject("invalidIdOrPassword", new Object[] {loginCommand.getId()}, null);
			
			return form();
		}		
	}
	
	
	
	
	
}
