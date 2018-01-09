package kr.spring.ch06.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.ch06.model.SearchCommand;
import kr.spring.ch06.model.SearchType;
import kr.spring.ch06.service.SearchService;

@Controller
public class GameSearchController {
	@Autowired
	private SearchService searchService;
	
	//@Autowired를 프로퍼티에 명시하면 setXXX메서드 생략 가능
	/*public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}*/
	@ModelAttribute("searchTypeList")
	public List<SearchType> searchTypeList(){
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1,"전체"));
		options.add(new SearchType(2,"아이템"));
		options.add(new SearchType(3,"내용"));
		
		return options;
	}
		
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
		System.out.println("검색어 = " + command.getQuery());
		
		String result = searchService.search(command);
		
		ModelAndView mav = new ModelAndView("search/game");
		mav.addObject("searchResult",result);
		
		return mav;
	}
	
}






