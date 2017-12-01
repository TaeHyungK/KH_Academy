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
		
		//전송된 데이터에 대한 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		//전송된 데이터를 반환
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		//MemberDao 호출
		MemberDao dao = MemberDao.getInstance();
		//getMember에 id 전달하고 자바빈 반환
		MemberDto member = dao.getMember(id);
		boolean check = false;
		
		//자바빈이 null이 아니면 isCheckedPasswd에 전송된 passwd
		if(member != null) {
			check = member.isCheckedPasswd(passwd);
		}
		//check가 true인지를 검사해서 true이면 속성명이
		//user_id : id (속성명:값)를 세션에 저장
		if(check) {
			HttpSession session = req.getSession();
			session.setAttribute("user_id", id);
		}
		//속성명을 check로 check를 request에 저장
		req.setAttribute("check", check);
		
		
		return "/views/member/login.jsp";
	}

}
