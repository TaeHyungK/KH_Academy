package kr.register.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.register.dao.Register_1Dao;
import kr.register_1.domain.Register_1Dto;

public class ModifyUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/register/loginForm.do";
		}
		
		request.setCharacterEncoding("utf-8");
		Register_1Dto register=new Register_1Dto();
		
		register.setId(user_id);
		register.setPasswd(request.getParameter("passwd"));
		register.setName(request.getParameter("name"));
		register.setPhone(Integer.parseInt(request.getParameter("phone")));
		register.setSex(request.getParameter("sex"));
		register.setCard_num(Integer.parseInt(request.getParameter("card_num")));
		
		Register_1Dao dao=Register_1Dao.getInstance();
		dao.updateRegister(register);
		
		return "/views/register/modifyUser.jsp";
	}

}
