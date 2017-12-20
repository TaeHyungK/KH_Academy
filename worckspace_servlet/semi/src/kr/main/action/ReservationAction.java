package kr.main.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class ReservationAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/main/main.do";
		}
		
		int num = Integer.parseInt(req.getParameter("snum"));
		String a_ticket = req.getParameter("a_ticket");
		String as_ticket = req.getParameter("as_ticket");
		String c_ticket = req.getParameter("c_ticket");
		if(a_ticket==null) {
			a_ticket = "0";
		}
		if(as_ticket==null) {
			as_ticket = "0";
		}
		if(c_ticket==null) {
			c_ticket = "0";
		}
		int a_ticket_num = Integer.parseInt(a_ticket);
		int as_ticket_num = Integer.parseInt(as_ticket);
		int c_ticket_num = Integer.parseInt(c_ticket);
		
		int ticket_num = a_ticket_num + as_ticket_num + c_ticket_num;
				
		AirDao dao = AirDao.getInstance();
		AirDto ada = dao.selectAir(num);
		List<Integer> rsv = dao.selectReservNum();
		int random = 100;
		for(int i = 0;i<rsv.size();i++) {
			random = (int)(Math.random()*1000);
			if(random==rsv.get(i)) {
				random = 0;
				i--;
			}
		} 
		int seats = dao.seats(ada.getAp_num());
		if(ticket_num>seats) {
			return "/views/reservation/notEnoughSeats.jsp";
		}  
		dao.updateReserv(ada,num,user_id,random, ticket_num,a_ticket_num,as_ticket_num,c_ticket_num);
		AirDto ad = dao.selectReservAir(random);
		req.setAttribute("ad", ad);
		req.setAttribute("random", random);
		return "/views/reservation/reservation.jsp";
	}

}























