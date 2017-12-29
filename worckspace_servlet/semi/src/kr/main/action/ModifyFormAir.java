package kr.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class ModifyFormAir implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		int snum = Integer.parseInt(req.getParameter("snum"));
		AirDao dao = AirDao.getInstance();
		AirDto ad = dao.selectAir(snum);
		req.setAttribute("ad", ad);
		return "/views/admin/adminModifyForm.jsp";
	}

}
