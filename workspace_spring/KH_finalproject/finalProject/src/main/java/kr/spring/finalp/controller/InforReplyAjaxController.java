package kr.spring.finalp.controller;

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

import java.util.Collections;

import kr.spring.finalp.domain.InforReplyCommand;
import kr.spring.finalp.service.InforService;
import kr.spring.util.PagingUtil;

@Controller
public class InforReplyAjaxController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	private int rowCount=10;
	
	@Resource
	private InforService inforService;
	
	//´ñ±Û ¸ñ·Ï
	@RequestMapping("/board/listReply.do")
	@ResponseBody
	public Map<String,Object> getList(@RequestParam(value="pageNum",defaultValue="1")int currentPage,
			@RequestParam("ib_num")int ib_num){
		
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>> : "+ currentPage);
			log.debug("<<ib_num>> : "+ ib_num);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("ib_num", ib_num);
		
		//ÃÑ ±ÛÀÇ °¹¼ö
		int count = inforService.getRowCountReply(map);
		
		//ÆäÀÌÂ¡ Ã³¸®
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, 1, null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<InforReplyCommand> list=null;
		
		if(count>0) {
			list = inforService.listReply(map);
			
		}else {
			list = Collections.emptyList();
		}
		
		System.out.println("count >> " + count);
		System.out.println("rowCount >> " + rowCount);
		System.out.println("list >> " + list);
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);
		
		return mapJson;
	}
	
	//´ñ±Û µî·Ï
	@RequestMapping("/board/writeReply.do")
	@ResponseBody
	public Map<String, String> insertReply(InforReplyCommand inforReply, HttpSession session,
			HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<inforReplyCommand>> : " + inforReply);
			}
		
		Map<String, String> map = new HashMap<String, String>();
		
		String id = (String)session.getAttribute("user_id");
		
		if(id == null) {
			//·Î±×ÀÎ ¾ÈµÊ
			map.put("result", "logout");
		}else {
			//·Î±×ÀÎ µÊ
			inforService.insertReply(inforReply);
			
			map.put("result", "success");
		}
		return map;
	}
	
	//´ñ±Û ¼öÁ¤
	@RequestMapping("/board/updateReply.do")
	@ResponseBody
	public Map<String, String> modifyReply(InforReplyCommand inforReply,
												HttpSession session, HttpServletRequest request){
		
		Map<String, String> map = new HashMap<String, String>();
		
		String id = (String)session.getAttribute("user_id");
		
		if(id == null) {
			map.put("result", "logout");
		}else if(id != null && id.equals(inforReply.getM_id())) {
			
			inforService.updateReply(inforReply);
			map.put("result", "success");
		}else {
			map.put("result", "wrongAccess");
		}
		return map;
	}
	
	//´ñ±Û »èÁ¦
	@RequestMapping("/board/deleteReply.do")
	@ResponseBody
	public Map<String,String> deleteReply(@RequestParam("if_num")int if_num, @RequestParam("m_id")String m_id, HttpSession session){
		
		Map<String,String> map = new HashMap<String, String>();
		
		String id = (String)session.getAttribute("user_id");
		
		if(id == null) {
			map.put("result", "logout");
			
		}else if(id != null && id.equals(m_id)) {
			inforService.deleteReply(if_num);
			map.put("result", "success");
			
		}else {
			map.put("result", "wrongAccess");
		}
		return map;
	}
	
}
