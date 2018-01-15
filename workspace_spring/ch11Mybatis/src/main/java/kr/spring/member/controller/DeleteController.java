package kr.spring.member.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.member.service.MemberService;

@Controller
public class DeleteController {
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/delete.do")
	public String form() {
		return "deleteForm";
	}
	
	@RequestMapping("/deletePro.do")
	public String process(@RequestParam String id) {
		
		memberService.deleteMember(id);
		
		return "redirect:/list.do";
	}
	
}








