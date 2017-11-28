package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class SelectDetailAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//전송된 데이터 저장
		String id = req.getParameter("id");
		//MemberDao 호출
		MemberDao dao = MemberDao.getInstance();
		//getMember메소드에 id를 전달하고 한 건의 레코드를 저장
		MemberDto member = dao.getMember(id);
				
		//데이터를 request에 저장
		req.setAttribute("member", member);
		
		return "/views/selectDetail.jsp";
	}

}
