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
		//session에서 user_id를 통해 값을 반환받아서 로그인 여부 체크
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id == null) {
			return "redirect:/main/loginForm.do";
		}
		//전송된 데이터에 대한 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		//자바빈을 생성
		MemberDto member = new MemberDto();
		//전송된 데이터를 자바빈에 저장
		member.setId(user_id);
		member.setName(req.getParameter("name"));
		member.setPasswd(req.getParameter("passwd"));
		member.setPhone(req.getParameter("phone"));
		member.setEmail(req.getParameter("email"));
		member.setZipcode(req.getParameter("zipcode"));
		member.setAddress1(req.getParameter("address1"));
		member.setAddress2(req.getParameter("address2"));
		//MemberDao 호출
		MemberDao dao = MemberDao.getInstance();
		//updateMember에 자바빈 전달
		dao.updateMember(member);
		
		return "/views/member/modifyUser.jsp";
	}

}
