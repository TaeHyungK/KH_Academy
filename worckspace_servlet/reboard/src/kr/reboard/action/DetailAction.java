package kr.reboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;
import kr.util.StringUtil;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//글 번호 반환
		int num = Integer.parseInt(
				request.getParameter("num"));
		//BoardDao 호출
		BoardDao dao = BoardDao.getInstance();
		//조회수 증가
		dao.updateReadcount(num);
		//글 번호와 매칭되는 레코드(데이터) 반환
		BoardDto board = dao.getReboard(num);
		//title : HTML를 불허
		//content : HTML를 불허, 줄바꿈
		board.setTitle(StringUtil.useNoHtml(
				          board.getTitle()));
		board.setContent(StringUtil.useBrNoHtml(
				           board.getContent()));
		
		//request에 board 저장
		request.setAttribute("board", board);
		
		return "/views/reboard/detail.jsp";
	}

}







