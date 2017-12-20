package kr.air.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.ReservationDao;
import kr.air.domain.ReservationDto;
import kr.controller.Action;
import kr.util.PagingUtil;

public class ReservationDetailAction implements Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");

		if(keyfield == null) keyfield = "";
		if(keyword == null) keyword = "";

		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";

		int rowCount = 20;
		int pageCount = 10;
		int currentPage = Integer.parseInt(pageNum);

		ReservationDao dao = ReservationDao.getInstance();
		int count = dao.getReservationCount(keyfield, "");

		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"list.do");

		List<ReservationDto> list = null;
		if(count > 0) {

			list = dao.getListReservation(id,page.getStartCount(), page.getEndCount(), keyfield, keyword);
		}
		request.setAttribute("count",count);
		request.setAttribute("list", list);
		request.setAttribute("pagingHtml", page.getPagingHtml());
		
		return "/views/register/reservationDetail.jsp";
	}

}
