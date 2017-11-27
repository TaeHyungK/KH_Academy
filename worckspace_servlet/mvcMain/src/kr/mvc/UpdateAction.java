package kr.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//데이터에 request 저장
		req.setAttribute("message", "게시판 정보 수정!!");
		
		return "views/update.jsp";
	}

}
