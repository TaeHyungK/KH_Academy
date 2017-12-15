package kr.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(id);
		boolean check = false;
		
		if(member!=null) {
			//��й�ȣ ��ġ ���� üũ
			check = member.isCheckePasswd(passwd);
		}
		
		if(check) {//���� ����
			HttpSession session = req.getSession();
			session.setAttribute("user_id", id);
			
			System.out.println(session.getAttribute("user_id"));
		}
		
		//check�� request�� ����
		req.setAttribute("check", check);
		
		return "/views/main/login.jsp";
	}

}
