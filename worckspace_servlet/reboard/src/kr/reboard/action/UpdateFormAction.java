package kr.reboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;

public class UpdateFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//�α��� ���� üũ
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id == null) {
			return "redirect:/member/loginForm.do";
		}
		
		//���۵� �۹�ȣ ��ȯ
		int num = Integer.parseInt(request.getParameter("num"));
		
		//BoardDao ȣ��
		BoardDao dao = BoardDao.getInstance();
		//getReboard�� num�� �����ؼ� �ڹٺ� ��ȯ
		BoardDto board = dao.getReboard(num);
		
		//�α��� ���̵�� �ۼ��� ���̵� ��ġ ����
		if(user_id!=null && !user_id.equals(board.getId())) {
			request.setAttribute("accessMsg", 
					"Ÿ���� ���� ������ �� �����ϴ�.");
			return "/views/common/notice.jsp";
		}
		//�ڹٺ��� request�� ����
		request.setAttribute("board", board);
		
		return "/views/reboard/updateForm.jsp";
	}

}







