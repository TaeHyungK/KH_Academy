package kr.spring.member.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.member.validator.MemberValidator;

@Controller
public class InsertController {

	@Resource
	private MemberService memberService;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	//커맨드 객체(자바빈) 초기화
	@ModelAttribute
	public MemberCommand inintcommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.GET)
	public String form() {
		return"insertForm";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String submit(MemberCommand memberCommand, BindingResult result){
		if(log.isDebugEnabled()) {
			log.debug("memberCommand: " + memberCommand);
		}
		
		//유효성 체크
		new MemberValidator().validate(memberCommand, result);
		
		if(result.hasErrors()) {
			return form();
		}
		
		//회원 등록
		memberService.insertrMember(memberCommand);
		
		return "redirect:/list.do";
	}
	
}
