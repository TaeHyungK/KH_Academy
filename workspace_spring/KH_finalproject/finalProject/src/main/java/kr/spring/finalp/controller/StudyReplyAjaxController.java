package kr.spring.finalp.controller;

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

import kr.spring.finalp.domain.StudyReplyCommand;
import kr.spring.finalp.service.StudyService;
import kr.spring.util.PagingUtil;

@Controller
public class StudyReplyAjaxController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	
	@Resource
	private StudyService studyService;
	
	//´ñ±Û ¸ñ·Ï
	@RequestMapping("/study/listReply.do")
	@ResponseBody
	public Map<String, Object> getList(@RequestParam(value="pageNum", defaultValue="1")int currentPage,
						@RequestParam("sb_num")int sb_num){
		
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>> : "+ currentPage);
			log.debug("<<ib_num>> : "+ sb_num);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("sb_num", sb_num);
		
		//ÃÑ ±ÛÀÇ °¹¼ö
		int count = studyService.getRowCountReply(map);
		
		//ÆäÀÌÂ¡ Ã³¸®
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, 1, null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<StudyReplyCommand> list = null;
		
		if(count > 0) {
			list = studyService.listReply(map);
		}else {
			list = Collections.emptyList();
		}
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);
		
		return mapJson;
	}
	
	//´ñ±Û µî·Ï
	@RequestMapping("/study/writeReply.do")
	@ResponseBody
	public Map<String, String> insertReply(StudyReplyCommand studyReply, HttpSession session,
			HttpServletRequest request){
		
		Map<String, String> map = new HashMap<String, String>();
		
		String id = (String)session.getAttribute("user_id");
		
		if(id == null) {
			//·Î±×ÀÎ ¾ÈµÊ
			map.put("result", "logout");
		}else {
			//·Î±×ÀÎ µÊ
			studyService.insertReply(studyReply);
			
			map.put("result", "success");
		}
		return map;
	}
	
	//´ñ±Û ¼öÁ¤
	@RequestMapping("/study/updateReply.do")
	@ResponseBody
	public Map<String, String> modifyReply(StudyReplyCommand studyReply,
						HttpSession session, HttpServletRequest request){
		
		Map<String, String> map = new HashMap<String, String>();
		
		String id = (String)session.getAttribute("user_id");
		
		if(id == null) {
			map.put("result", "logout");
		}else if(id != null && id.equals(studyReply.getM_id())){
			
			studyService.updateReply(studyReply);
			map.put("result", "success");
		}else {
			map.put("result", "wrongAccess");
		}
		return map;
	}
	
	//´ñ±Û »èÁ¦
	@RequestMapping("/study/deleteReply.do")
	@ResponseBody
	public Map<String, String> deleteReply(@RequestParam("sc_num")int sc_num, @RequestParam("m_id")String m_id, HttpSession session){
		
		Map<String, String> map = new HashMap<String, String>();
		
		String id = (String)session.getAttribute("user_id");
		
		if(id == null) {
			map.put("result", "logout");
		}else if(id != null && id.equals(m_id)) {
			studyService.deleteReply(sc_num);
			map.put("result", "success");
		}else {
			map.put("result", "wrongAccess");
		}
		return map;
	}
}
