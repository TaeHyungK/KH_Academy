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
		System.out.println("������ ���� �� : " + loginCommand);

		//���۵� �����Ϳ� ���� ��ȿ�� üũ
		new LoginCommandValidator().validate(loginCommand, result);
		
		//BindingResult�� ��ȿ�� üũ ��� ������ ���� ������
		//����Ǿ� ������ ���� �ٽ� ȣ����
		if(result.hasErrors()) {
			return form();
		}
		
		return "redirect:/index.jsp";
	}
}
