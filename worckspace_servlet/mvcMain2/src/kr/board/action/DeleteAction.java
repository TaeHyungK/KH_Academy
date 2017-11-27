package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setAttribute("delete", "게시판 글 삭제!!");
		return "/views/delete.jsp";
	}

}
