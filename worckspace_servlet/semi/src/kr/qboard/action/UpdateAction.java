package kr.qboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.qboard.dao.QboardDao;
import kr.qboard.domain.QboardDto;


public class UpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id ==null) {
				return "redirect:/member/loginForm.do";
		}
		request.setCharacterEncoding("utf-8");
		
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		
		//QboardDao ȣ��
		QboardDao dao = QboardDao.getInstance();
		
		QboardDto qboard = dao.getBoard(q_num);
		if(user_id!=null && !user_id.equals(qboard.getQ_id())) {
			request.setAttribute("accessMsg", "Ÿ���� ���� �����Ҽ� �����ϴ�");
			return "/views/qboard/notice.jsp";
		}
		qboard.setQ_num(q_num);
		qboard.setQ_title(request.getParameter("q_title"));
		qboard.setQ_content(request.getParameter("q_content"));
		
		//updateBoard�� �ڹٺ� ����
		dao.updateBoard(qboard);
		
		return "redirect:/qboard/qlist.do";
	}

}
