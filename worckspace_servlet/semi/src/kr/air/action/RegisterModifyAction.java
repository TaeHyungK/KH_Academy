package kr.air.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.ManagerDao;
import kr.air.domain.ManagerDto;
import kr.controller.Action;

public class RegisterModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		ManagerDto manager = new ManagerDto();
		
		manager.setId(id);
		manager.setName(request.getParameter("name"));
		manager.setPhone(request.getParameter("phone"));
		manager.setSex(request.getParameter("sex"));
		manager.setCard_num(request.getParameter("card_num"));
		
		ManagerDao dao = ManagerDao.getInstance();
		
		dao.updateRegister_1(manager);
		
		return "/views/register/registerModify.jsp";
	}

}
