package kr.reboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;

public class WriteAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//�α��� ���� üũ
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id == null) {
			return "redirect:/member/loginForm.do";
		}
		
		//���۵� �����Ϳ� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		//�ڹٺ� ����
		BoardDto board = new BoardDto();
		//�ڹٺ� ���۵� ������ ����
		//title, content, ip, id
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		board.setIp(req.getRemoteAddr());
		board.setId(user_id);
		//BoardDaoȣ��
		BoardDao dao = BoardDao.getInstance();
		//insertReboard()�� �ڹٺ� ����
		dao.insertReboard(board);
		
		return "/views/reboard/write.jsp";
	}

}
