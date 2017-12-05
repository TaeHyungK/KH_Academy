package kr.reboard.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;
import kr.util.PagingUtil;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		//검색 처리
		/*String keyfield = req.getParameter("keyfield");
		String keyword = req.getParameter("keyword");

		if(keyfield == null) keyfield = "";
		if(keyword == null) keyword = "";*/
		String keyfield = "";
		String keyword = "";
		
		//pageNum 처리(null이면 1페이지로 처리
		String pageNum = req.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";

		int rowCount = 20;
		int pageCount = 10;
		int currentPage = Integer.parseInt(pageNum);

		//BoardDao 호출
		BoardDao dao = BoardDao.getInstance();
		//레코드 수 반환
		int count = dao.getReboardCount(keyfield, keyword);

		//PagingUtil객체 생성
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage,count,rowCount,pageCount,"list.do");
		
		//목록 호출
		List<BoardDto> list = null;
		if(count>0) {
			list = dao.getListReboard(page.getStartCount(), page.getEndCount(), keyfield, keyword);
		}

		//request에 count, list, pagingHtml을 저장
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.setAttribute("pagingHtml", page.getPagingHtml());
		
		
		return "/views/reboard/list.jsp";
	}

}
