package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class ModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//傈价等 单捞磐俊 措茄 牢内爹 贸府
		req.setCharacterEncoding("UTF-8");
		
		//磊官后 按眉 积己
		MemberDto member = new MemberDto();
		member.setId(req.getParameter("id"));
		member.setPasswd(req.getParameter("passwd"));
		member.setName(req.getParameter("name"));
		
		MemberDao dao = MemberDao.getInstance();
		dao.updateMember(member);
		
		return "/views/modify.jsp";
	}

}
