package kr.main.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List<AirDto> list = new ArrayList<AirDto>();
		AirDao dao = AirDao.getInstance();
		list = dao.listSchedule();
		req.setAttribute("list", list);
		
		System.out.println(list);
		return "/views/list/scheduleList.jsp";
	}
}





























