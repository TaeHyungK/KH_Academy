package kr.reservation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.reservation.dao.ReservationDao;
import kr.reservation.domain.ReservationDto;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		ReservationDao dao=ReservationDao.getInstance();
		
		ReservationDto reservation=dao.getReservation(num);
		
		request.setAttribute("reservation", reservation);
		
		return "/views/mypage_reservation/detail.jsp";
	}

}
