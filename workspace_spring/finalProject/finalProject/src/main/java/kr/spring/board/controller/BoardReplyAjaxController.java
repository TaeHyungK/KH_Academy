package kr.spring.board.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.board.service.BoardService;
import kr.spring.util.PagingUtil;

@Controller
public class BoardReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	
	@Resource
	private BoardService boardService;
	
	//댓글 목록
	@RequestMapping("/board/listReply.do")
	@ResponseBody
	public Map<String,Object> getList(@RequestParam(value="pageNum",defaultValue="1")int currentPage,
									  @RequestParam("num")int num){
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>> : " + currentPage);
			log.debug("<<num>> : " + num);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("num", num);
		
		//총 글의 갯수
		int count = boardService.getRowCountReply(map);
		//페이징 처리
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,1,null);
		map.put("start",page.getStartCount());
		map.put("end",page.getEndCount());
		
		List<BoardReplyCommand> list = null;
		if(count>0) {
			list = boardService.listReply(map);
		}else {
			list = Collections.emptyList();
		}
		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);
		
		return mapJson;
	}
	
	//댓글 등록
	@RequestMapping("/board/writeReply.do")
	@ResponseBody
	public Map<String,String> writeReply(BoardReplyCommand boardReplyCommand,HttpSession session,HttpServletRequest request){
		if(log.isDebugEnabled()) {
			log.debug("<<boardReplyCommand>> : " + boardReplyCommand);
		}
		Map<String,String> map = new HashMap<String, String>();
		
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id==null) {
			//로그인 안됨
			map.put("result", "logout");
		}else {
			//로그인 됨
			
			//ip 저장
			boardReplyCommand.setRe_ip(request.getRemoteAddr());
			
			//댓글 등록
			boardService.insertReply(boardReplyCommand);
			
			map.put("result","success");
		}
		
		return map;
	}
	//댓글 수정
	@RequestMapping("/board/updateReply.do")
	@ResponseBody
	public Map<String,String> modifyReply(BoardReplyCommand boardReplyCommand, HttpSession session, HttpServletRequest request){
		if(log.isDebugEnabled()) {
			log.debug("<<boardReplyCommand>> : " + boardReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			map.put("result","logout");
		}else if(user_id!=null && user_id.equals(boardReplyCommand.getId())) {
			map.put("result", "success");
			//ip저장
			boardReplyCommand.setRe_ip(request.getRemoteAddr());
			//댓글 수정
			boardService.updateReply(boardReplyCommand);
		}else {
			map.put("result", "wrongAcess");
		}
		
		return map;
	}
	//댓글 삭제
	@RequestMapping("/board/deleteReply.do")
	@ResponseBody
	public Map<String,String> deleteReply(@RequestParam("re_num")int re_num,@RequestParam("id")String id,HttpSession session){
		
		if(log.isDebugEnabled()) {
			log.debug("<<re_num>> : " + re_num);
			log.debug("<<id>> : " + id);
		}
		Map<String,String> map = new HashMap<String,String>();
		
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			//로그인 되어 있지 않음
			map.put("result", "logout");
		}else if(user_id!=null&&user_id.equals(id)){
			//로그인 되어 있고 로그인한 아이디와 작성자 아이디가 같을 때
			boardService.deleteReply(re_num);
			map.put("result", "success");
		}else {
			map.put("result","wrongAccess");
		}
		
		return map;
	}
	
}








































