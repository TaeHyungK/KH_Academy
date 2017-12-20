package kr.main.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id==null) {
			return "redirect:/main/do-not-reserv.do";
		}
		
		List<AirDto> list = new ArrayList<AirDto>();
		AirDao dao = AirDao.getInstance();
		list = dao.listSchedule();
		req.setAttribute("list", list);
		return "/views/list/scheduleList.jsp";
	}
}





























