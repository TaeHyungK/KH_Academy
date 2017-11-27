package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setAttribute("detail", "게시판 글 상세보기!!");
		return "/views/detail.jsp";
	}

}
