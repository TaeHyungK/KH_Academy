package kr.air.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.ReservationDao;
import kr.controller.Action;

public class ReservationDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		String rsv_num = request.getParameter("rsv_num");

		if(user_id == null) {
			return "redirect:/member/loginForm.do";
		}
		
		ReservationDao dao = ReservationDao.getInstance();
		
		dao.deleteReservation(rsv_num);
		
		request.setAttribute("rsv_num", rsv_num);
		
		return "/views/register/reservationDelete.jsp";
	}

}
