package kr.register.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.register.dao.Register_1Dao;
import kr.register_1.domain.Register_1Dto;

public class DeleteUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/register/loginForm.do";
		}
		
		Register_1Dao dao=Register_1Dao.getInstance();
		Register_1Dto register=dao.getRegister(user_id);
		boolean check=false;
		
		if(register!=null) {
			request.setCharacterEncoding("utf-8");
			
			String passwd=request.getParameter("passwd");
			
			check=register.isCheckedPasswd(passwd);
		}
		
		if(check) {
			dao.deleteRegister(user_id);
			session.invalidate();
		}
		
		request.setAttribute("check", check);
		
		return "/views/register/deleteUser.jsp";
	}

}
