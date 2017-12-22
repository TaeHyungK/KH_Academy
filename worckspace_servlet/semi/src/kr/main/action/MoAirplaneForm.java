package kr.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.domain.AirDto;
import kr.controller.Action;

public class MoAirplaneForm implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		AirDto ad = new AirDto();
		String ap_num = req.getParameter("ap_num");
		int seats = Integer.parseInt(req.getParameter("seats"));
		ad.setAp_num(ap_num);
		ad.setSeats(seats);
		req.setAttribute("ad", ad);
		
		return "/views/admin/moAirplaneForm.jsp";
	}

}
