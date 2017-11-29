package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.MemberDto;

public class RegisterUserAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//전송된 데이터에 대한 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		//자바빈 객체 생성
		MemberDto member = new MemberDto();
		//전송된 데이터를 자바빈에 저장
		//id, name, passwd, phone, email, zipcode, address1, address2
		member.setId(req.getParameter("id"));
		member.setName(req.getParameter("name"));
		member.setPasswd(req.getParameter("passwd"));
		member.setPhone(req.getParameter("phone"));
		member.setEmail(req.getParameter("email"));
		member.setZipcode(req.getParameter("zipcode"));
		member.setAddress1(req.getParameter("address1"));
		member.setAddress2(req.getParameter("address2"));
		//MemberDao 호출
		MemberDao dao = MemberDao.getInstance();
		//insertMember에 자바빈 전달
		dao.insertMember(member);
		
		return "/views/member/registerUser.jsp";
	}

}
