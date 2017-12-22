package kr.qboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardDto;

public class UpdateFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session =request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id == null) {
			return "redirect:/";
		}
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		QboardDao dao = QboardDao.getInstance();
		QboardDto qboard = dao.getBoard(q_num);
		
		
		if(user_id!=null && !user_id.equals(qboard.getQ_id())) {
			request.setAttribute("accessMsg", "타인의 글을 수정할수 없습니다");
		     return "/views/qboard/notice.jsp";
		}
		request.setAttribute("qboard", qboard);
		
		return "/views/qboard/qupdateForm.jsp";
	}

}
