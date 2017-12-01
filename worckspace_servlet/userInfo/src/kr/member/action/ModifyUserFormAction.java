package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class ModifyUserFormAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//HttpSession 구하기
		HttpSession session = req.getSession();
		//user_id를 입력해서 세션에서 반환
		String user_id = (String)session.getAttribute("user_id");
		//user_id가 null인지 조건체크
		//null일 경우 /member/loginForm.do로 redirect
		if(user_id==null) { //로그인 없이 직접 uri입력으로 들어왔을 경우를 체크하는 것
			return "redirect:/main/loginForm.do";
		}
		//MemberDao 호출
		MemberDao dao = MemberDao.getInstance();
		//getMember에 user_id를 전달해서 자바빈 반환
		MemberDto member = dao.getMember(user_id);
		//자바빈을 request에 저장
		req.setAttribute("member", member);
		
		return "/views/member/modifyUserForm.jsp";
	}

}
