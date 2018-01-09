package kr.spring.ch04.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageRanksController {
	@RequestMapping("/pageRanks.do")
	public ModelAndView handle() {
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		
		pageRanks.add(new PageRank(1,"/bbs/mir2/list"));
		pageRanks.add(new PageRank(2,"/bbs/mir2/detail"));
		pageRanks.add(new PageRank(3,"/bbs/mir2/write"));
								//ºä ÀÌ¸§			¸ðµ¨ÀÌ¸§
		return new ModelAndView("pageRanks", "pageRanks", pageRanks);
		
	}
}
