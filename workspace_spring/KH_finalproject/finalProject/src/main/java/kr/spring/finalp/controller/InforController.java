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

import kr.spring.finalp.domain.InforCommand;
import kr.spring.finalp.service.InforService;
import kr.spring.util.PagingUtil;
import kr.spring.util.StringUtil;

@Controller
public class InforController {

	private Logger log = Logger.getLogger(this.getClass());

	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private InforService inforService;

	@RequestMapping("/board/list.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1")int currentPage,
			@RequestParam(value="keyfield", defaultValue="")String keyfield,
			@RequestParam(value="keyword", defaultValue="")String keyword){
			
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		int count = inforService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count,
								rowCount, pageCount, "list.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<InforCommand> list = null;
		
		if(count > 0) {
			list = inforService.list(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		return mav;
	}
	
	//글쓰기
	@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
	public String writeform(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("user_id");
		
		InforCommand command = inforService.selectId(id);
		
		model.addAttribute("command",command);
		
		return "boardWrite";
	}
	@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
	public String submitWrite(	@ModelAttribute("command")
								@Valid InforCommand inforCommand,
								BindingResult result,
								HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<InforCommand>> : " + inforCommand);
		}
		
		if(result.hasErrors()) {
			return "boardWrite";
		}
				
		inforService.insert(inforCommand);
		
		return "redirect:/board/list.do";
	}
	
	//글 상세보기
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam("ib_num")int ib_num) {
		
		//해당 글의 조회수 증가
		inforService.updateHit(ib_num);
		
		InforCommand form = inforService.selectNum(ib_num);
		
		form.setIb_title(StringUtil.useBrNoHtml(form.getIb_title()));
		form.setIb_content(StringUtil.useBrNoHtml(form.getIb_content()));
		
		return new ModelAndView("boardView", "form", form);
	}
	
	//글 수정
	@RequestMapping(value="/board/update.do", method=RequestMethod.GET)
	public String updateform(@RequestParam("ib_num")int ib_num, Model model) {
		
		InforCommand inforCommand = inforService.selectNum(ib_num);
		model.addAttribute("command", inforCommand);
		
		return "boardModify";
	}
	@RequestMapping(value="/board/update.do", method = RequestMethod.POST)
	public String submitUpdate(	@ModelAttribute("command")
								@Valid InforCommand inforCommand,
								BindingResult result,
								HttpServletRequest request) {
		
		inforService.update(inforCommand);
		
		return "redirect:/board/list.do";
	}
	
	//글 삭제
	@RequestMapping("/board/delete.do")
	public String submitDelete(	@RequestParam("ib_num")int ib_num,
								HttpSession session) {
		
		inforService.delete(ib_num);
		
		return "redirect:/board/list.do";
	}
	
}
