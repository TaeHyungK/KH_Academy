package kr.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class AirList implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		AirDao dao = AirDao.getInstance();
		List<AirDto> list = dao.AirplaneList();
		
		req.setAttribute("list", list);
		return "/views/admin/airList.jsp";
	}

}
