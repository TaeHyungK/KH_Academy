package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class DeleteUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//�α��� ���� üũ
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/member/loginForm.do";
		}
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(user_id);
		boolean check = false;
		
		if(member!=null) {
			//���۵� �����Ϳ� ���� ���ڵ� ó��
			request.setCharacterEncoding("utf-8");
			//���۵� ������ ��ȯ
			String passwd = request.getParameter("passwd");
			//��й�ȣ ��ġ ���� üũ
			check = member.isCheckedPasswd(passwd);
		}
		
		if(check) {
			//ȸ����������
			dao.deleteMember(user_id);
			//�α׾ƿ�
			session.invalidate();
		}
		
		request.setAttribute("check", check);
		
		return "/views/member/deleteUser.jsp";
	}

}







