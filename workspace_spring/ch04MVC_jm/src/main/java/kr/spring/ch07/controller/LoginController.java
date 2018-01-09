package kr.spring.ch07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch07.model.LoginCommand;
import kr.spring.ch07.service.LoginService;
import kr.spring.ch07.validator.LoginCommandValidator;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

   @Autowired
   private LoginService loginService;

   //�ڹٺ� �ʱ�ȭ
   //�Ӽ����� ����� ������� ������ Ŭ�������� ù ���ڸ� �ҹ��ڷ� �Ӽ������� ����
   @ModelAttribute
   public LoginCommand initCommand() {
      return new LoginCommand();
   }

   @RequestMapping(method=RequestMethod.GET)
   public String form() {
      return "login/form";
   }

   @RequestMapping(method=RequestMethod.POST)
   public String submit(LoginCommand loginCommand, BindingResult result) {
      System.out.println("������ ���� �� : " + loginCommand);

      //���۵� �����Ϳ� ���� ��ȿ�� üũ
      new LoginCommandValidator().validate(loginCommand, result);

      //BindingResult�� ��ȿ�� üũ ��� ������ ���� ������
      //����Ǿ� ������ ���� �ٽ� ȣ����
      if(result.hasErrors()) {
         return form();
      }

      //�α��� üũ
      try {
         loginService.checkAuth(loginCommand);
         return "rediret:index.jsp";
      }catch(Exception e) {
         //�α��� ���н� ����� ���� �޼��� ����
                        //���� �ڵ�         //�޼����� ���޵� ����                     //default message
         result.reject("invalidIdOrPassword", new Object[] {loginCommand.getUserId()}, null);

         return form();
      }
   }
}