package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class RegisterUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//전송된 데이터에 대한 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//자바빈 객체 생성
		MemberDto member = new MemberDto();
		//전송된 데이터를 자바빈에 저장
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPasswd(request.getParameter("passwd"));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress1(request.getParameter("address1"));
		member.setAddress2(request.getParameter("address2"));
		
		//MemberDao 호출
		MemberDao dao = MemberDao.getInstance();
		//insertMember에 자바빈 전달
		dao.insertMember(member);
				
		return "/views/member/registerUser.jsp";
	}

}






