package kr.spring.member.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.util.PagingUtil;

@Controller
public class SelectListController {
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/list.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1")int currentPage) {
		
		int count = memberService.getMemberCount();
		
		PagingUtil page = new PagingUtil(currentPage, count, 10, 10, "list.do");
		List<MemberCommand> list = null;
		if(count > 0) {
			list = memberService.getMemberList(page.getStartCount(), page.getEndCount());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
}
