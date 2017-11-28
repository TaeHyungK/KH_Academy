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
		
		//MemberDao ȣ��
		MemberDao dao = MemberDao.getInstance();
		//getMemberList() ȣ���ؼ� List ��ü ��ȯ
		List<MemberDto> memberList = dao.getMemberList();
		
		//List ��ü�� request�� ����
		req.setAttribute("memberList", memberList);
		
		return "/views/select.jsp";
	}
}
