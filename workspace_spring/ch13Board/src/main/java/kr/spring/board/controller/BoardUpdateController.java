package kr.spring.board.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.service.BoardService;

@Controller
public class BoardUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping(value="/board/update.do", method=RequestMethod.GET)
	public String form(@RequestParam("num") int num, Model model) {
		BoardCommand boardCommand = boardService.selectBoard(num);
		model.addAttribute("command", boardCommand);
		
		return "boardModify";
	}
	
}
