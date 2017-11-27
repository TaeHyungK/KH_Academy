package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//데이터를 request에 저장
		req.setAttribute("list", "게시판 목록!!");
		
		//JSP 경로 반환
		return "/views/list.jsp";
	}

}
