package kr.main.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;

public class SearchAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id==null) {
			return "redirect:/main/do-not-reserv.do";
		}
		AirDto ad = new AirDto();
		String start = req.getParameter("start_location");
		ad.setStart_lo(start);
		String end = req.getParameter("end_location");
		ad.setEnd_lo(end);
		String go = req.getParameter("go_date");
		ad.setGo_date(go);
		String re = req.getParameter("return_date");
		ad.setReturn_date(re);
		
		 if(start.equals("")||end.equals("")||go.equals("")||re.equals("")) {
	         List<AirDto> list = new ArrayList<AirDto>();
	         AirDao dao = AirDao.getInstance();
	         list = dao.listSchedule();
	         req.setAttribute("list", list);
	         return "/views/list/scheduleList.jsp";
	      }
		
		System.out.println("SearchAction ->" + ad);
		
		AirDao dao = AirDao.getInstance();
		List<AirDto> list = null;
		list = dao.searchInfo(ad);
		req.setAttribute("list", list);
		return "/views/reservation/reservationForm.jsp";
	}

}
