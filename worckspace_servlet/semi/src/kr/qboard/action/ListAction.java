package kr.qboard.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardDto;
import kr.util.PagingUtil;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String keyfield = request.getParameter("keyfield");
	    String keyword = request.getParameter("keyword");
	    
	    if(keyfield ==null) keyfield="";
	    else keyfield = "q_"+keyfield;
	    if(keyword ==null) keyword="";
		
		//페이지 num 처리
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) pageNum="1";
		
		int rowCount= 20;
		int pageCount = 10;
		int currentPage = Integer.parseInt(pageNum);
		
		QboardDao dao = QboardDao.getInstance();
		//레코드 수 반환
		int count = dao.getQboardCount(keyfield, keyword);
		//PagingUtil 객체 생성
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"list.do");
		//목록 호출
		List<QboardDto> list = null;
		if(count >0) {
			list = dao.getListQboard(page.getStartCount(), page.getEndCount(), keyfield, keyword);
		}
		//request에 count, list, Paginghtml을 저장
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("pagingHtml", page.getPagingHtml());
	
		
		return "/views/qboard/qlist.jsp";
	}

}
