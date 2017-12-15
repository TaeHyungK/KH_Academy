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
		
		/*//�α��� ���� üũ
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
				
		if(user_id == null) {
			return "redirect:/";
		}
		*/
		int q_num =Integer.parseInt(request.getParameter("q_num"));
		//QboardDao ȣ��
		QboardDao dao = QboardDao.getInstance();
		//getBaord()�� q_num�� �����ؼ� �ڹٺ� ��ȯ
		QboardDto qboard = dao.getBoard(q_num);
		
		/*//���� ������ ����
		if(user_id != null && !user_id.equals(qboard.getQ_id())) {
			request.setAttribute("accessMsg", "Ÿ���� ���� �����Ҽ� �����ϴ�");
			return "/views/common/notice.jsp";
		}*/
		
		//�� ���� 
		dao.deleteBoard(q_num);
		
		return "redirect:/qboard/qlist.do";
	}

}
