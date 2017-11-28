package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class SelectDetailAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//���۵� ������ ����
		String id = req.getParameter("id");
		//MemberDao ȣ��
		MemberDao dao = MemberDao.getInstance();
		//getMember�޼ҵ忡 id�� �����ϰ� �� ���� ���ڵ带 ����
		MemberDto member = dao.getMember(id);
				
		//�����͸� request�� ����
		req.setAttribute("member", member);
		
		return "/views/selectDetail.jsp";
	}

}
