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
		
		//전송된 데이터에 대한 인코딩
		request.setCharacterEncoding("utf-8");
		//전송된 데이터 반환
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//MemberDao호출
		MemberDao dao = MemberDao.getInstance();
		//getMember에 id전달하고 자바빈 반환
		MemberDto member = dao.getMember(id);
		boolean check = false;
		
		if(member!=null) {
			//비밀번호 일치 여부 체크
			check = member.isCheckedPasswd(passwd);
		}
		
		if(check) {//인증 성공
			//로그인 처리
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
			session.setAttribute("user_level", member.getUser_level());
		}
		
		//check를 request에 저장
		request.setAttribute("check", check);
		
		return "/views/member/login.jsp";
	}

}





