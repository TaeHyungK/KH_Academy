package kr.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.AirDao;
import kr.controller.Action;

public class DeAirplane implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		 req.setCharacterEncoding("utf-8");
	      String ap_num = req.getParameter("ap_num");
	      AirDao dao = AirDao.getInstance();
	      boolean res = dao.AirResCheck(ap_num);
	      if(res==false) {
	    	  dao.deAirp(ap_num);
	    	  return "/views/admin/do_success.jsp";
	      }
	      return "/views/admin/deleteFalse.jsp";
	}

}
