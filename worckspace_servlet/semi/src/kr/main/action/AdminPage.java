package kr.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class AdminPage implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("utf-8");

		AirDto ad = new AirDto();
		if(req.getParameter("start_lo")!=null) {
		ad.setStart_lo(req.getParameter("start_lo"));
		ad.setEnd_lo(req.getParameter("end_lo"));
		ad.setGo_date(req.getParameter("go_date"));
		ad.setGo_time(req.getParameter("go_time"));
		ad.setReturn_date(req.getParameter("return_date"));
		ad.setReturn_time(req.getParameter("return_time"));
		ad.setTake_time(req.getParameter("take_time"));
		ad.setSeats(Integer.parseInt(req.getParameter("seats")));
		ad.setAp_num(req.getParameter("ap_num"));
		ad.setSnum(Integer.parseInt(req.getParameter("snum")));
		AirDao dao = AirDao.getInstance();
		dao.modifyAir(ad);
		}
		AirDao dao = AirDao.getInstance();
		
		List<AirDto> list = dao.listSchedule();
		req.setAttribute("list", list);
		return "/views/admin/adminReserv.jsp";
	}
}
