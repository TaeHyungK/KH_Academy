package kr.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.controller.Action;

public class InsertAirPlane implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		if(req.getParameter("ap_num")==null||req.getParameter("seats")==null) {
			return "/views/admin/checkInput.jsp";
		}
		String air = req.getParameter("ap_num");
		int seats = Integer.parseInt(req.getParameter("seats"));
		AirDao dao = AirDao.getInstance();
		dao.insertAirPlane(air, seats);
		
		return "/views/admin/do_success.jsp";
	}

}
