package kr.air.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.air.dao.ManagerDao;
import kr.air.domain.ManagerDto;
import kr.controller.Action;

public class RegisterModifyLoginFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		String id = request.getParameter("id");
		
		if(user_id == null) {
			return "redirect:/member/loginForm.do";
		}
		
		ManagerDao dao = ManagerDao.getInstance();
		ManagerDto manager = dao.getManager(user_id);
		boolean check = false;
		
		if(manager!=null) {
			//전송된 데이터에 대한 인코딩 처리
			request.setCharacterEncoding("utf-8");
			//전송된 데이터 반환
			String passwd = request.getParameter("passwd");
			//비밀번호 일치 여부 체크
			check = manager.isCheckedPasswd(passwd);
		}
		
		if(check) {
			dao.deleteRegister_1(id);
		}
		
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		return "/views/register/registerModifyLoginForm.jsp";
	}

}
