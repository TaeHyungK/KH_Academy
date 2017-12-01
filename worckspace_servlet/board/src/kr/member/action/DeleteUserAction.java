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
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/member/loginForm.do";
		}
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(user_id);
		boolean check = false;
		
		if(member!=null) {
			//전송된 데이터에 대한 인코딩 처리
			request.setCharacterEncoding("utf-8");
			//전송된 데이터 반환
			String passwd = request.getParameter("passwd");
			//비밀번호 일치 여부 체크
			check = member.isCheckedPasswd(passwd);
		}
		
		if(check) {
			//회원정보삭제
			dao.deleteMember(user_id);
			//로그아웃
			session.invalidate();
		}
		
		request.setAttribute("check", check);
		
		return "/views/member/deleteUser.jsp";
	}

}







