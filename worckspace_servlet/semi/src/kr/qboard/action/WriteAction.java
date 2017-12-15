package kr.qboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardDto;

public class WriteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
		/*//로그인 여부 체크 필요시
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			return "redirect:/member/loginForm.do";
		}*/
		request.setCharacterEncoding("utf-8");
		
		QboardDto qboard = new QboardDto();
		
		qboard.setQ_title(request.getParameter("title"));
		qboard.setQ_id(request.getParameter("name"));
		qboard.setQ_content(request.getParameter("content"));
		qboard.setQ_solve(Integer.parseInt(request.getParameter("solve")));
		
		QboardDao dao = QboardDao.getInstance();
		dao.insertQboard(qboard);
		
		return "/views/qboard/qwrite.jsp";
	}

}
