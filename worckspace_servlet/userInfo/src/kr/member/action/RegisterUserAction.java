package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class RegisterUserAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		//�ڹٺ� ��ü ����
		MemberDto member = new MemberDto();
		//���۵� �����͸� �ڹٺ� ����
		//id, name, passwd, phone, email, zipcode, address1, address2
		member.setId(req.getParameter("id"));
		member.setName(req.getParameter("name"));
		member.setPasswd(req.getParameter("passwd"));
		member.setPhone(req.getParameter("phone"));
		member.setEmail(req.getParameter("email"));
		member.setZipcode(req.getParameter("zipcode"));
		member.setAddress1(req.getParameter("address1"));
		member.setAddress2(req.getParameter("address2"));
		//MemberDao ȣ��
		MemberDao dao = MemberDao.getInstance();
		//insertMember�� �ڹٺ� ����
		dao.insertMember(member);
		
		return "/views/member/registerUser.jsp";
	}

}
