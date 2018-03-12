package kr.spring.finalp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.finalp.domain.StudyCommand;
import kr.spring.finalp.service.StudyService;
import kr.spring.util.PagingUtil;
import kr.spring.util.StringUtil;

@Controller
public class StudyController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private StudyService studyService;
	
	@RequestMapping("/study/sblist.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1")int currentPage,
			@RequestParam(value="keyfield", defaultValue="")String keyfield,
			@RequestParam(value="keyword", defaultValue="")String keyword) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		int count = studyService.getRowCount(map);
		
		PagingUtil page = 
				new PagingUtil(keyfield, keyword, currentPage, count, rowCount, pageCount, "sblist.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<StudyCommand> list = null;
		
		if(count > 0) {
			list = studyService.list(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("studyList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
		}
		
	//글쓰기
	@RequestMapping(value="/study/sbwrite.do", method=RequestMethod.GET)
	public String writeform(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("user_id");
		
		StudyCommand command = studyService.selectId(id);
		
		model.addAttribute("command", command);
		
		return "studyWrite";
	}
	
	@RequestMapping(value="/study/sbwrite.do", method=RequestMethod.POST)
	public String submitWrite(@ModelAttribute("command")
									@Valid StudyCommand studyCommand,
									BindingResult result,
									HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "studyWrite";
		}
		
		studyService.insert(studyCommand);
		
		return "redirect:/study/sblist.do";
	}
	
	//글 상세보기
	@RequestMapping("/study/sbdetail.do")
	public ModelAndView process(@RequestParam("sb_num")int sb_num) {
		
		//해당 글의 조회수 증가
		studyService.updateHit(sb_num);
		
		StudyCommand form = studyService.selectNum(sb_num);
		
		form.setSb_title(StringUtil.useBrNoHtml(form.getSb_title()));
		form.setSb_content(StringUtil.useBrNoHtml(form.getSb_content()));
		
		return new ModelAndView("studyView", "form", form);
	}
	
	//글 수정
	@RequestMapping(value="/study/sbupdate.do", method=RequestMethod.GET)
	public String updateform(@RequestParam("sb_num")int sb_num, Model model) {
		
		StudyCommand studyCommand = studyService.selectNum(sb_num);
		model.addAttribute("command", studyCommand);
		
		return "studyModify";
	}
	@RequestMapping(value="/study/sbupdate.do", method = RequestMethod.POST)
	public String submitUpdate(@ModelAttribute("command")
									@Valid StudyCommand studyCommand,
									BindingResult result,
									HttpServletRequest request) {
		
		studyService.update(studyCommand);
		
		return "redirect:/study/sblist.do";
	}
	
	
	//글 삭제
	@RequestMapping("/study/sbdelete.do")
	public String submitDelete(@RequestParam("sb_num")int sb_num,
														HttpSession session) {
		studyService.delete(sb_num);
		
		return "redirect:/study/sblist.do";
	}
}

