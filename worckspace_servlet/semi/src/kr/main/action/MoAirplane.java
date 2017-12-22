package kr.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.controller.Action;

public class MoAirplane implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		
		if(req.getParameter("seats")==null) {
			return "/views/admin/checkInput.jsp";
		}
		AirDao dao = AirDao.getInstance();
		String ap_num = req.getParameter("ap_num");
		int seats = Integer.parseInt(req.getParameter("seats"));
		dao.moAirp(ap_num, seats);
		
		return "/views/admin/do_success.jsp";
	}

}
