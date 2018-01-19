package kr.spring.board.controller;

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
	
	@RequestMapping(value="/board/update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
						 @Valid BoardCommand boardCommand, BindingResult result, HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<boardCommand >> : " + boardCommand);
		}
		
		//파일을 수정하지 않으면 기존 파일을 넣거나 파일명이 누락되는 경우 기존 파일명을 기억해놓기 위해 저장함
		BoardCommand board = boardService.selectBoard(boardCommand.getNum()); 
		
		if(result.hasErrors()) {
			//원래 파일명 셋팅
			boardCommand.setFilename(board.getFilename());
			return "boardModify";
		}
		
		//전송된 파일이 없을 경우
		if(boardCommand.getUpload().isEmpty()) {
			//기존 정보를 셋팅
			boardCommand.setUploadfile(board.getUploadfile());
			boardCommand.setFilename(board.getFilename());
			
			return "boardModify";
		}
		
		//ip셋팅
		boardCommand.setIp(request.getRemoteAddr());
		
		//글수정
		boardService.update(boardCommand);
				
		return "redirect:/board/list.do";
	}
	
}
