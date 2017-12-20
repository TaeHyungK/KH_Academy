package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class ModifyPasswordAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/main/main.do";
		}
		
		req.setCharacterEncoding("UTF-8");
		
		MemberDto member = new MemberDto();
		member.setId(user_id);
		member.setPasswd(req.getParameter("passwd"));
		
		MemberDao dao = MemberDao.getInstance();
		dao.updatePassword(member);
		
		return "redirect:/main/main.do";
	}

}
