package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class ModifyFormAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String id = req.getParameter("id");
		System.out.println("req.id:" + id);
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(id);
		
		req.setAttribute("member", member);
		System.out.println(req.getAttribute("member"));
		
		return "/views/modifyForm.jsp";
	}

}
