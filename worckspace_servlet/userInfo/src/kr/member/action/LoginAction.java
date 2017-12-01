package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		//���۵� �����͸� ��ȯ
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		//MemberDao ȣ��
		MemberDao dao = MemberDao.getInstance();
		//getMember�� id �����ϰ� �ڹٺ� ��ȯ
		MemberDto member = dao.getMember(id);
		boolean check = false;
		
		//�ڹٺ��� null�� �ƴϸ� isCheckedPasswd�� ���۵� passwd
		if(member != null) {
			check = member.isCheckedPasswd(passwd);
		}
		//check�� true������ �˻��ؼ� true�̸� �Ӽ�����
		//user_id : id (�Ӽ���:��)�� ���ǿ� ����
		if(check) {
			HttpSession session = req.getSession();
			session.setAttribute("user_id", id);
		}
		//�Ӽ����� check�� check�� request�� ����
		req.setAttribute("check", check);
		
		
		return "/views/member/login.jsp";
	}

}
