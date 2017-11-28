package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		
		MemberDao dao = MemberDao.getInstance();
		dao.deleteMember(id);
		
		return "/views/delete.jsp";
	}
}
