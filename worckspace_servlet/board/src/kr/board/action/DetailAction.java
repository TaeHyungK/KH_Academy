package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardDto;
import kr.controller.Action;
import kr.util.StringUtil;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//글 번호 반환
		int num = Integer.parseInt(req.getParameter("num"));
		//BoardDao 객체 생성
		BoardDao dao = BoardDao.getInstance();
		//조회수 증가
		dao.updateReadcount(num);
		//getBoard메소드 호출
		//글 번호와 매칭되는 레코드(데이터)반환
		BoardDto board = dao.getBoard(num);
		//HTML을 불허하면서 줄바꿈 처리
		board.setTitle(StringUtil.useNoHtml(board.getTitle()));
		board.setContent(StringUtil.useBrNoHtml(board.getContent()));
		//request에 자바빈 저장
		req.setAttribute("board", board);
		return "/views/board/detail.jsp";
	}

}
