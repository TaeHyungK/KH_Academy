package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class ModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		
		//�ڹٺ� ��ü ����
		MemberDto member = new MemberDto();
		member.setId(req.getParameter("id"));
		member.setPasswd(req.getParameter("passwd"));
		member.setName(req.getParameter("name"));
		
		MemberDao dao = MemberDao.getInstance();
		dao.updateMember(member);
		
		return "/views/modify.jsp";
	}

}
