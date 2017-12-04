package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardDto;
import kr.controller.Action;
import kr.util.StringUtil;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//�� ��ȣ ��ȯ
		int num = Integer.parseInt(req.getParameter("num"));
		//BoardDao ��ü ����
		BoardDao dao = BoardDao.getInstance();
		//��ȸ�� ����
		dao.updateReadcount(num);
		//getBoard�޼ҵ� ȣ��
		//�� ��ȣ�� ��Ī�Ǵ� ���ڵ�(������)��ȯ
		BoardDto board = dao.getBoard(num);
		//HTML�� �����ϸ鼭 �ٹٲ� ó��
		board.setTitle(StringUtil.useNoHtml(board.getTitle()));
		board.setContent(StringUtil.useBrNoHtml(board.getContent()));
		//request�� �ڹٺ� ����
		req.setAttribute("board", board);
		return "/views/board/detail.jsp";
	}

}
