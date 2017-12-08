package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//���۵� �����Ϳ� ���� ���ڵ�
		request.setCharacterEncoding("utf-8");
		//���۵� ������ ��ȯ
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//MemberDaoȣ��
		MemberDao dao = MemberDao.getInstance();
		//getMember�� id�����ϰ� �ڹٺ� ��ȯ
		MemberDto member = dao.getMember(id);
		boolean check = false;
		
		if(member!=null) {
			//��й�ȣ ��ġ ���� üũ
			check = member.isCheckedPasswd(passwd);
		}
		
		if(check) {//���� ����
			//�α��� ó��
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
			session.setAttribute("user_level", member.getUser_level());
		}
		
		//check�� request�� ����
		request.setAttribute("check", check);
		
		return "/views/member/login.jsp";
	}

}





