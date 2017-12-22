package kr.main.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.air.dao.AirDao;
import kr.controller.Action;

public class CheckDup implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		HashMap<String, String> map = new HashMap<String,String>();
		String ap_num = null;
		if(req.getParameter("ap_num")==null) {
			ap_num="";
		}else {
			ap_num = req.getParameter("ap_num");
		}
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null || !user_id.equals("admin")) {
			map.put("result", "adminOnly");
		}else {
			AirDao dao = AirDao.getInstance();
			boolean du = dao.AirDup(ap_num);
			if(du) {
				map.put("result","numDu");
			}else {
				map.put("result", "success");
			}
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = 
				mapper.writeValueAsString(map);
		
		req.setAttribute("jsonData", jsonData);
		return "/views/common/ajaxView.jsp";
	}

}






















