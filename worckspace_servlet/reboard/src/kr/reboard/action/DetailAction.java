package kr.reboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;
import kr.util.StringUtil;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//�� ��ȣ ��ȯ
		int num = Integer.parseInt(
				request.getParameter("num"));
		//BoardDao ȣ��
		BoardDao dao = BoardDao.getInstance();
		//��ȸ�� ����
		dao.updateReadcount(num);
		//�� ��ȣ�� ��Ī�Ǵ� ���ڵ�(������) ��ȯ
		BoardDto board = dao.getReboard(num);
		//title : HTML�� ����
		//content : HTML�� ����, �ٹٲ�
		board.setTitle(StringUtil.useNoHtml(
				          board.getTitle()));
		board.setContent(StringUtil.useBrNoHtml(
				           board.getContent()));
		
		//request�� board ����
		request.setAttribute("board", board);
		
		return "/views/reboard/detail.jsp";
	}

}







