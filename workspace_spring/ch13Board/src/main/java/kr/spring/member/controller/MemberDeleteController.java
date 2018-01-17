package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;

	@RequestMapping(value="/member/delete.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String) session.getAttribute("user_id");
		
		MemberCommand member = new MemberCommand();
		member.setId(id);
		
		model.addAttribute("command", member);
		
		return "memberDelete";
	}
	
	@RequestMapping(value="/member/delete.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
						 @Valid MemberCommand memberCommand, BindingResult result, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		
		String id = (String) session.getAttribute("user_id");
		
		//id,passwd 필드의 에러만 체크
		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return "memberDelete";
		}
		
		//비밀번호 일치 여부 체크
		try {
			MemberCommand member = memberService.selectMember(memberCommand.getId());
			boolean check = false;
						
			if(member != null) {
				//비밀번호 체크
				check = member.isCheckedPasswd(memberCommand.getPasswd());
			}
			
			if(check) {
				//인증 성공, 회원 정보 삭제
				memberService.delete(memberCommand.getId());
				//로그아웃
				session.invalidate();
				return "redirect:/main/main.do";
			}else {
				throw new Exception();
			}	
		}catch(Exception e) {
			result.rejectValue("passwd", "invalidPassword");
			return "memberDelete";
		}
		
	}
	
	
}
