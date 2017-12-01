package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class DeleteUserAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//로그인 여부 체크
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) { //로그인 없이 직접 uri입력으로 들어왔을 경우를 체크하는 것
			return "redirect:/main/loginForm.do";
		}
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(user_id);
		boolean check = false;
		
		if(member!=null) {
			//전송된 데이터에 대한 인코딩 처리
			req.setCharacterEncoding("UTF-8");
			//전송된 데이터 반환
			String passwd = req.getParameter("passwd");
			//비밀번호 일치 여부 체크
			check=member.isCheckedPasswd(passwd);
		}
		
		if(check) {
			//회원정보 삭제
			dao.deleteMember(user_id);
			//로그아웃
			session.invalidate();
		}
		
		req.setAttribute("check", check);
		
		

		return "/views/member/deleteUser.jsp";
	}

}
