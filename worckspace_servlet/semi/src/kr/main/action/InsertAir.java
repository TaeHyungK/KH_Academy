package kr.main.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class InsertAir implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		AirDao dao = AirDao.getInstance();
		
		System.out.println("LOG::" + req.getParameter("start_lo") + "/" + req.getParameter("end_lo")+"/"+req.getParameter("go_date")+"/"+req.getParameter("return_date")+"/"+req.getParameter("take_time")+"/"+req.getParameter("ap_num")+"/"+req.getParameter("snum"));
		
		if(req.getParameter("start_lo")==null||req.getParameter("end_lo")==null||req.getParameter("go_date")==null||req.getParameter("return_date")==null||req.getParameter("take_time")==""||req.getParameter("ap_num")==null) {
			return "/views/admin/checkInput.jsp";
		}
		AirDto ad = new AirDto();
		ad.setStart_lo(req.getParameter("start_lo"));
		ad.setEnd_lo(req.getParameter("end_lo"));
		ad.setGo_date(req.getParameter("go_date"));
		ad.setReturn_date(req.getParameter("return_date"));
		ad.setGo_time(req.getParameter("go_time"));
		ad.setReturn_time(req.getParameter("return_time"));
		ad.setTake_time(req.getParameter("take_time"));
		ad.setAp_num(req.getParameter("ap_num"));
		ad.setSeats(dao.selectAirplaneSeats(req.getParameter("ap_num")));
		dao.insertAir(ad);
		List<AirDto> list = new ArrayList<AirDto>();
		list = dao.listSchedule();
		req.setAttribute("list", list);
		
		return "/views/admin/adminInsertComplete.jsp";
	}

}
