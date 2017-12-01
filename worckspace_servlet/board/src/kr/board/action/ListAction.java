package kr.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardDto;
import kr.controller.Action;
import kr.util.PagingUtil;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNum = req.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		
		int rowCount = 20; //한 페이지의 게시물 수
		int pageCount = 10;//한 화면의 페이지수
		int currentPage = Integer.parseInt(pageNum);
		
		BoardDao dao = BoardDao.getInstance();
		//전체 레코드 수 반환
		int count = dao.getBoardCount("", "");
		
		//페이징 처리
		PagingUtil page = new PagingUtil("","",currentPage,count,rowCount,pageCount,"list.do");
		
		List<BoardDto> list = null;
		if(count>0) {
			list = dao.getListBoard(page.getStartCount(), page.getEndCount(), "", "");
		}		
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.setAttribute("pagingHtml", page.getPagingHtml());
		
		return "/views/board/list.jsp";
	}
}
