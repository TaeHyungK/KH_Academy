package kr.reboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;

public class UpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//�α��� ���� üũ
		HttpSession session = request.getSession();
		String user_id = 
				(String)session.getAttribute("user_id");
		if(user_id == null) {
			return "redirect:/member/loginForm.do";
		}
		
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		request.setCharacterEncoding("utf-8");
		//���۵� �۹�ȣ ��ȯ
		int num = 
		Integer.parseInt(request.getParameter("num"));
		
		//BoardDao ȣ��
		BoardDao dao = BoardDao.getInstance();
		//������ �����͸� ��ȯ ����
		BoardDto dbBoard = dao.getReboard(num);
		
		//�α����� ���̵�� �� �ۼ��� ���̵� üũ
		if(user_id!=null && 
				!user_id.equals(dbBoard.getId())) {
			request.setAttribute("accessMsg", 
					"Ÿ���� ���� ������ �� �����ϴ�.");
			return "/views/common/notice.jsp";
		}
		//�ڹٺ� ����
		BoardDto board = new BoardDto();
		//�ڹٺ� ���۵� �����͸� ����
		board.setNum(num);
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setIp(request.getRemoteAddr());
		
		//updateBoard �� �ڹٺ� ����
		dao.updateReboard(board);
		
		return "redirect:/board/list.do";
	}

}









