package kr.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//데이터를 request에 저장
		req.setAttribute("message", "게시판에 글 작성!");
		
		return "/views/write.jsp";
	}

}
