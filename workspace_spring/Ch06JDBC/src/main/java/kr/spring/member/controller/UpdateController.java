package kr.spring.member.controller;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.member.validator.MemberValidator;

@Controller
public class UpdateController {
	@Resource MemberService memberService;
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String form(@RequestParam String id, Model model) {
		
		model.addAttribute("memberCommand", memberService.getMember(id));
		
		return "updateForm";
	}
		
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String submit(@RequestParam MemberCommand memberCommand, BindingResult result) {
		
		//유효성 검사
		new MemberValidator().validate(memberCommand, result);
		
		if(result.hasErrors()) {
			return "updateForm";
		}
		
		memberService.updateMember(memberCommand);
		
		return "redirect:list.do";
	}
}
