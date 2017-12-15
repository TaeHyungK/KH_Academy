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
		
		/* //�α��� ���� üũ
		HttpSession session =request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id == null) {
			return "redirect:/";
		}*/
		int q_num = Integer.parseInt(request.getParameter("q_num"));
		QboardDao dao = QboardDao.getInstance();
		QboardDto qboard = dao.getBoard(q_num);
		
		/*//�α����� ���̵� �ۼ��ھ��̵�� ��ġ���� üboũ
		if(user_id!=null && !user_id.equals(board.getId())) {
			request.setAttribute("accessMsg", "Ÿ���� ���� �����Ҽ� �����ϴ�");
		     return "/views/common/notice.jsp";
		}*/
		request.setAttribute("qboard", qboard);
		
		return "/views/qboard/qupdateForm.jsp";
	}

}
