package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;

public class DeleteUserFormAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		//로그인 여부 체크
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) { //로그인 없이 직접 uri입력으로 들어왔을 경우를 체크하는 것
			return "redirect:/main/loginForm.do";
		}

		return "/views/member/deleteUserForm.jsp";
	}

}
