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
		
		/* //로그인 여부 체크
		HttpSession session =request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id == null) {
			return "redirect:/";
		}*/
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		QboardDao dao = QboardDao.getInstance();
		QboardDto qboard = dao.getBoard(q_num);
		
		/*//로그인한 아이디가 작성자아이디와 일치여부 체bo크
		if(user_id!=null && !user_id.equals(board.getId())) {
			request.setAttribute("accessMsg", "타인의 글을 수정할수 없습니다");
		     return "/views/common/notice.jsp";
		}*/
		request.setAttribute("qboard", qboard);
		
		return "/views/qboard/qupdateForm.jsp";
	}

}
