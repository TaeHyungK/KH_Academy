package kr.register.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.register.dao.Register_1Dao;
import kr.register.domain.Register_1Dto;

public class ModifyUserFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		
		if(user_id==null) {
			return "redirect:/register/loginForm.do";
		}
		
		Register_1Dao dao=Register_1Dao.getInstance();
		
		Register_1Dto register=dao.getRegister(user_id);
		
		request.setAttribute("register", register);
		
		return "/views/mypage_user/registerModifyForm.jsp";
	}

}
