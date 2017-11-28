package kr.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class SelectAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//MemberDao 호출
		MemberDao dao = MemberDao.getInstance();
		//getMemberList() 호출해서 List 객체 반환
		List<MemberDto> memberList = dao.getMemberList();
		
		//List 객체를 request에 저장
		req.setAttribute("memberList", memberList);
		
		return "/views/select.jsp";
	}
}
