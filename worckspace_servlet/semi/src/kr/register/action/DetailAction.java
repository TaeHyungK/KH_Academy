package kr.register.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;
import kr.controller.Action;
import kr.register.dao.Register_1Dao;
import kr.register.domain.Register_1Dto;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String user_id =(String)session.getAttribute("user_id");
		if(user_id==null) {
			return "/views/mypage_user/loginCheck.jsp";
		}
		
		Register_1Dao dao=Register_1Dao.getInstance();
		Register_1Dto register=dao.getRegister(user_id);
		
		AirDao addao = AirDao.getInstance();
		List<AirDto> list = addao.checkReserv(user_id);
		request.setAttribute("register", register);
		request.setAttribute("list", list);
		return "/views/mypage_user/registerDetail.jsp";
	}

}
