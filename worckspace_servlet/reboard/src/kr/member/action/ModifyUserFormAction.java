package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class ModifyUserFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//HttpSession ���ϱ�
		HttpSession session = request.getSession();
		//user_id �Է��ؼ� ���� ���ǿ��� ��ȯ
		String user_id = 
			(String)session.getAttribute("user_id");
		//�α����� �Ǿ����� ������ loginForm���� redirect
		if(user_id==null) {
			return "redirect:/member/loginForm.do";
		}
		
		//MemberDao�� ȣ��
		MemberDao dao = MemberDao.getInstance();
		//getMember�� user_id�� �����ؼ� �ڹٺ� ��ȯ
		MemberDto member = dao.getMember(user_id);
		//�ڹٺ��� request�� ����
		request.setAttribute("member", member);
		
		return "/views/member/modifyUserForm.jsp";
	}

}






