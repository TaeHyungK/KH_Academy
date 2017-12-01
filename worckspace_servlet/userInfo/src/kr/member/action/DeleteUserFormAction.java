package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;

public class DeleteUserFormAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		//�α��� ���� üũ
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) { //�α��� ���� ���� uri�Է����� ������ ��츦 üũ�ϴ� ��
			return "redirect:/main/loginForm.do";
		}

		return "/views/member/deleteUserForm.jsp";
	}

}
