package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;

public class ModifyPasswordFormAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/main/main.do";
		}
		
		return "/views/member/modifyPasswordForm.jsp";
	}

}
