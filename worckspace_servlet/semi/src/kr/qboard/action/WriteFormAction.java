package kr.qboard.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;

public class WriteFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//로그인  체크 사용시
	    HttpSession session = request.getSession();
	    String user_id =(String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/main/main.do";
		}
		
		return "/views/qboard/qwriteForm.jsp";
	}

}
