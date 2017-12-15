package kr.air.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.ManagerDao;
import kr.air.domain.ManagerDto;
import kr.controller.Action;
import kr.util.PagingUtil;
   
public class RegisterListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//검색 처리
		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");
		
		if(keyfield == null) keyfield = "";
		if(keyword == null) keyword = "";
		
		//pageNum 처리(null이면 1페이지로 처리)
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		
		int rowCount = 20;
		int pageCount = 10;
		int currentPage = Integer.parseInt(pageNum);
		
		//Dao 호출
		ManagerDao dao = ManagerDao.getInstance();
		//레코드 수 반환
		int count = dao.getReboardCount(keyfield, "");
		//PagingUtil 객체 생성
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"list.do");
		//목록 호출
		List<ManagerDto> list = null;
		if(count > 0) {
			list = dao.getListReboard(page.getStartCount(), page.getEndCount(), keyfield, keyword);
		}
		//request에 저장
		request.setAttribute("count",count);
		request.setAttribute("list", list);
		request.setAttribute("pagingHtml", page.getPagingHtml());
		
		System.out.println("count = " + count);
		System.out.println("list = " + list);
		
		return "/views/register/registerList.jsp";
	}

}





