package kr.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class Do_Not_Reserv implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		return "/views/reservation/do_not_reserv.jsp";
	}

}
