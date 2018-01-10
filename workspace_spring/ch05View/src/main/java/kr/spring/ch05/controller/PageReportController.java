package kr.spring.ch05.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageReportController {

	@RequestMapping("/pageXmlReport.do")
	@ResponseBody
	public PageRankReport xmlReport() {
		List<PageRank> pageRanks = new ArrayList<PageRank>();

		pageRanks.add(new PageRank(1, "/bbs/mir2/list"));
		pageRanks.add(new PageRank(2, "/bbs/mir2/detail"));
		pageRanks.add(new PageRank(3, "/bbs/mir2/write"));

		return new PageRankReport(pageRanks);
	}

	@RequestMapping("/pageJsonReport.do")
	@ResponseBody
	public List<PageRank> jsonRanks(){
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "bb1.ir/list.do"));
		pageRanks.add(new PageRank(2, "bb1.ir/list.do"));
		pageRanks.add(new PageRank(2, "bb1.ir/list.do"));

		return pageRanks;
	}
}
