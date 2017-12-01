package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class ModifyUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//session���� user_id�� ���� ���� ��ȯ�޾Ƽ�
		//�α��� ���� üũ
		HttpSession session = request.getSession();
		String user_id = 
			(String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/member/loginForm.do";
		}
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		request.setCharacterEncoding("utf-8");
		//�ڹٺ� ����
		MemberDto member = new MemberDto();
		//���۵� �����͸� �ڹٺ� ����
		member.setId(user_id);
		member.setName(request.getParameter("name"));
		member.setPasswd(request.getParameter("passwd"));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress1(request.getParameter("address1"));
		member.setAddress2(request.getParameter("address2"));
		//MemberDao ȣ��
		MemberDao dao = MemberDao.getInstance();
		//updateMember�� �ڹٺ� ����
		dao.updateMember(member);
		
		return "/views/member/modifyUser.jsp";
	}

}






