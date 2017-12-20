package kr.reservation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.reservation.dao.ReservationDao;
import kr.reservation.domain.ReservationDto;

public class updateAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/register/loginForm.do";
		}
		
		request.setCharacterEncoding("utf-8");
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		ReservationDao dao=ReservationDao.getInstance();
		
		ReservationDto dbReservation=dao.getReservation(num);
		
		ReservationDto reservation=new ReservationDto();
		
		reservation.setRsv_num(request.getParameter("rsv_num"));
		reservation.setDeparture(request.getParameter("departure"));
		reservation.setDestination(request.getParameter("destination"));
		reservation.setAp_num(request.getRemoteAddr());
		
		dao.updateReservation(reservation);
		
		return "redirect:/mypage_reservation/list.do";
	}

}
