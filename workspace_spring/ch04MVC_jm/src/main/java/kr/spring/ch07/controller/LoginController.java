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

   //자바빈 초기화
   //속성명을 제대로 명시하지 않으면 클래스에서 첫 글자를 소문자로 속성명으로 지정
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
      System.out.println("데이터 전송 후 : " + loginCommand);

      //전송된 데이터에 대한 유효성 체크
      new LoginCommandValidator().validate(loginCommand, result);

      //BindingResult에 유효성 체크 결과 오류에 대한 내용이
      //저장되어 있으면 폼을 다시 호출함
      if(result.hasErrors()) {
         return form();
      }

      //로그인 체크
      try {
         loginService.checkAuth(loginCommand);
         return "rediret:index.jsp";
      }catch(Exception e) {
         //로그인 실패시 사용할 에러 메세지 지정
                        //에러 코드         //메세지에 전달될 인자                     //default message
         result.reject("invalidIdOrPassword", new Object[] {loginCommand.getUserId()}, null);

         return form();
      }
   }
}