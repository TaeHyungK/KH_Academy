package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberLoginController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//커맨드객체(자바빈) 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String form() {
		return "memberLogin";
	}
	
	@RequestMapping(value="/member/login.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand,BindingResult result,HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		//id,passwd필드만 체크
		if(result.hasFieldErrors("id")||result.hasFieldErrors("passwd")) {
			return form();
		}
		//로그인 체크
		try {
			MemberCommand member = memberService.selectMember(memberCommand.getId());
			boolean check = false;
			if(member!=null) {
				//비밀번호 일치 여부 체크
				check = member.isCheckedPasswd(memberCommand.getPasswd());
			}
			if(check) {
				//인증 성공,로그인 처리
				session.setAttribute("user_id", memberCommand.getId());
				session.setAttribute("user_auth", memberCommand.getAuth());
				return "redirect:/main/main.do";
			}else {
				//인증,로그인 실패시 catch로 넘김
				throw new Exception();
			}
		}catch(Exception e) {
			result.reject("invalidIdOrPassword");
			//인증 실패로 폼 호출
			return form();
		}
	}
	//로그 아웃
	@RequestMapping("/member/logout.do")
	public String process(HttpSession session) {
		session.invalidate();
		return "redirect:/main/main.do";
	}
}





















