package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class RegisterAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		MemberDto member = new MemberDto();
		
		member.setId(req.getParameter("id"));
		member.setPasswd(req.getParameter("passwd"));
		member.setName(req.getParameter("name"));
		member.setPhone(req.getParameter("phone"));
		member.setSex(req.getParameter("sex"));
		member.setCard_num(req.getParameter("card_num"));
		
		MemberDao dao = MemberDao.getInstance();
		dao.insertMember(member);
		
		return "/views/member/registerUser.jsp";
	}

}
