package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class UpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setAttribute("update", "게시판 글 수정!!");
		
		return "/views/update.jsp";
	}

}
