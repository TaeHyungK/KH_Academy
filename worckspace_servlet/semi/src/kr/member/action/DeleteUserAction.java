package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class DeleteUserAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/main/main.do";
		}
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(user_id);
		boolean check = false;
		boolean check_user = false;
		
		if(member!=null) {
			req.setCharacterEncoding("UTF-8");
			String passwd = req.getParameter("passwd");
			
			check = member.isCheckePasswd(passwd);
		}
		if(check) {
			check_user = dao.deleteMember(user_id);
			if(check_user) {
				session.invalidate();
			}
		}
		
		req.setAttribute("check", check);
		req.setAttribute("check_user", check_user);
		
		return "/views/member/deleteUser.jsp";
	}

}
