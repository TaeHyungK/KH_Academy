package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class ModifyUserAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//session���� user_id�� ���� ���� ��ȯ�޾Ƽ� �α��� ���� üũ
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id == null) {
			return "redirect:/main/loginForm.do";
		}
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		//�ڹٺ��� ����
		MemberDto member = new MemberDto();
		//���۵� �����͸� �ڹٺ� ����
		member.setId(user_id);
		member.setName(req.getParameter("name"));
		member.setPasswd(req.getParameter("passwd"));
		member.setPhone(req.getParameter("phone"));
		member.setEmail(req.getParameter("email"));
		member.setZipcode(req.getParameter("zipcode"));
		member.setAddress1(req.getParameter("address1"));
		member.setAddress2(req.getParameter("address2"));
		//MemberDao ȣ��
		MemberDao dao = MemberDao.getInstance();
		//updateMember�� �ڹٺ� ����
		dao.updateMember(member);
		
		return "/views/member/modifyUser.jsp";
	}

}
