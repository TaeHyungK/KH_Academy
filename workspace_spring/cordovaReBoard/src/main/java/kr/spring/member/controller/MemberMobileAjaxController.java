package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberMobileAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//�α��� üũ ����
	@RequestMapping("/member/loginCheckAjax.do")
	@ResponseBody
	public Map<String, Object> checkLogin(HttpSession session){
		
		String id = (String)session.getAttribute("user_id");
		
		if(log.isDebugEnabled()) {
			log.debug("<<id>> : " + id);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(id!=null) {
			map.put("id", id);
			map.put("user_level", session.getAttribute("user_level"));
			map.put("result", "success");
		}else {
			map.put("result", "failure");
		}
		
		
		return map;
	}
	
	//�α��� 
	@RequestMapping("/member/loginAjax.do")
	@ResponseBody
	public Map<String, Object> doLogin(@RequestParam("id") String id,
										@RequestParam("passwd") String passwd,
										HttpSession session){
		
		if(log.isDebugEnabled()) {
			log.debug("<<id>> : " + id);
			log.debug("<<passwd>> : " + passwd);
		}
		
		MemberCommand member = memberService.selectMember(id);
		
		boolean check = false;
		if(member != null) {
			//��й�ȣ üũ
			check = member.isCheckedPasswd(passwd);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(check) {
			session.setAttribute("user_id", id);
			session.setAttribute("user_level", member.getAuth());
			
			map.put("result", "success");
		}else {
			map.put("result", "failure");
		}
		
		return map;
	}
	
	//�α׾ƿ�
	@RequestMapping("/member/logoutAjax.do")
	@ResponseBody
	public Map<String, String> doLogout(HttpSession session){
		
		session.invalidate();
		
		Map<String, String> map = new HashMap<String,String>(); 
		map.put("result", "success");
		
		return map;
	}
	
	//ȸ������
	@RequestMapping("/member/registerUserAjax.do")
	@ResponseBody
	public Map<String, String> registerUser(MemberCommand member){
		
		if(log.isDebugEnabled()) {
			log.debug("<<member>> : " + member);
		}
		
		Map<String, String> map = new HashMap<String,String>();
		
		memberService.insert(member);
		map.put("result", "success");
		
		return map;
	}
	
	
}
