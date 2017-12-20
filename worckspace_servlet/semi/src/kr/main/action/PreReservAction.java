package kr.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class PreReservAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id==null) {
			return "redirect:/main/main.do";
		}
		int num = Integer.parseInt(req.getParameter("snum"));
		
		AirDao dao = AirDao.getInstance();
		AirDto ad = dao.selectAir(num);
		
		req.setAttribute("ad", ad);
		return "/views/reservation/preReserv.jsp";
	}

}
