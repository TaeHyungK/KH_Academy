package kr.spring.member.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class SelectController {
	@Resource
	private MemberService memberService;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/detail.do")
	public ModelAndView process(@RequestParam String id) {
		
		//로그 표시
		if(log.isDebugEnabled()) {
			log.debug("id : " + id);
		}
		
		MemberCommand member = 
				memberService.getMember(id);
		return new ModelAndView("selectDetail","member",member);
	}
}









