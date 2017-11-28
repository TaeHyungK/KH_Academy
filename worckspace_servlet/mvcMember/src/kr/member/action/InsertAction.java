package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class InsertAction implements Action{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		//�ڹٺ� ����
		MemberDto member = new MemberDto();
		//���۵� �����͸� �ڹٺ� ����
		member.setId(req.getParameter("id"));
		member.setPasswd(req.getParameter("passwd"));
		member.setName(req.getParameter("name"));
				
		//MemberDao ȣ��
		MemberDao dao = MemberDao.getInstance();
		//insertMember�� �ڹٺ� ����
		dao.insertMember(member);
		
		return "/views/insert.jsp";
	}

}
