package kr.register.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;

public class DeleteUserFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		
		if(user_id==null) {
			return "redirect:/register/loginForm.jsp";
		}
		
		return "/views/mypage_user/registerDeleteForm.jsp";
	}

}
