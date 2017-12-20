package kr.main.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;

public class PeopleAir implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		
		HashMap<String, String> map =  new HashMap<String,String>();
		
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/main/main.do";
		}
		
		int a_ticket = Integer.parseInt(req.getParameter("a_ticket"));
		int as_ticket = Integer.parseInt(req.getParameter("as_ticket"));
		int c_ticket = Integer.parseInt(req.getParameter("c_ticket"));
		int total = a_ticket + as_ticket + c_ticket;
		System.out.println(""+a_ticket + as_ticket + c_ticket);
		if(total==0) {
			map.put("result", "success");
		}else if(total>0){
			map.put("result", "exist");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(map);
		
		req.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}
