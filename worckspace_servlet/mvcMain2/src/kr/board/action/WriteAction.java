package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class WriteAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setAttribute("write", "게시판 글쓰기!!");
		
		return "/views/write.jsp";
	}

}
