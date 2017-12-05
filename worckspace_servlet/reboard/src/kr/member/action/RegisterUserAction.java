package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class RegisterUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		request.setCharacterEncoding("utf-8");
		//�ڹٺ� ��ü ����
		MemberDto member = new MemberDto();
		//���۵� �����͸� �ڹٺ� ����
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPasswd(request.getParameter("passwd"));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress1(request.getParameter("address1"));
		member.setAddress2(request.getParameter("address2"));
		
		//MemberDao ȣ��
		MemberDao dao = MemberDao.getInstance();
		//insertMember�� �ڹٺ� ����
		dao.insertMember(member);
				
		return "/views/member/registerUser.jsp";
	}

}






