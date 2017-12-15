package kr.reservation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.reservation.dao.ReservationDao;
import kr.reservation.domain.ReservationDto;

public class updateFormation implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/register/loginForm.do";
		}
		
		int num=Integer.parseInt(request.getParameter("num"));
		ReservationDao dao=ReservationDao.getInstance();
		ReservationDto reservation=dao.getReservation(num);
		
		request.setAttribute("reservation",reservation);
		return "/views/reservation/updateForm.jsp";
	}

}
