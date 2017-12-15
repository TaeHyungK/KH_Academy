package kr.air.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.ManagerDao;
import kr.air.domain.ManagerDto;
import kr.controller.Action;

public class RegisterDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		System.out.println(user_id);
		if(user_id == null) {
			return "redirect:/member/loginForm.do";
		}
		String id = request.getParameter("id");
		
		System.out.println(id);
		
		ManagerDao dao = ManagerDao.getInstance();
		
		dao.deleteRegister_1(id);
		
		return "/views/register/registerDelete.jsp";
	}

}
