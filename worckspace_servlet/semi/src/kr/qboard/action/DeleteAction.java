package kr.qboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardDto;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
				
		if(user_id == null) {
			request.setAttribute("accessMsg", "로그인이 필요합니다");
			return "redirect:/";
		}
		
		int q_num =Integer.parseInt(request.getParameter("q_num"));
		//QboardDao 호출
		QboardDao dao = QboardDao.getInstance();
		//getBaord()에 q_num을 전달해서 자바빈에 반환
		QboardDto qboard = dao.getBoard(q_num);
		
		
		if(user_id != null && !user_id.equals(qboard.getQ_id())) {
			request.setAttribute("accessMsg", "타인의 글을 삭제할수 없습니다");
			return "/views/qboard/notice.jsp";
		}
		
		//글 삭제 
		dao.deleteBoard(q_num);
		
		return "redirect:/qboard/qlist.do";
	}

}
