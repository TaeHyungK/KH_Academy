package kr.main.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class DeleteAir implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		int snum = Integer.parseInt(req.getParameter("snum"));
		AirDao dao = AirDao.getInstance();
		boolean res = dao.reserv_num(snum);
		if(res==false) {
			dao.deleteAir(snum);
			List<AirDto> list = new ArrayList<AirDto>();
			list = dao.listSchedule();
			req.setAttribute("list", list);
			return "/views/admin/adminReserv.jsp";			
		}
		return "/views/admin/deleteFalse.jsp";
	}
}
