package kr.air.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class RegisterModifyFormAction implements Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		request.setAttribute("id", id);
		
		return "/views/register/registerModifyForm.jsp";
	}

}
