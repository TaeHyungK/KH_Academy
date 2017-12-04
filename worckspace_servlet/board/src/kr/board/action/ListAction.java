package kr.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardDto;
import kr.controller.Action;
import kr.util.PagingUtil;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//�˻� ó��
		String keyfield = req.getParameter("keyfield");
		String keyword = req.getParameter("keyword");
		
		if(keyfield == null) keyfield = "";
		if(keyword == null) keyword = "";
		
		
		//������ ó��
		String pageNum = req.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		
		int rowCount = 18; //�� �������� �Խù� ��
		int pageCount = 10;//�� ȭ���� ��������
		int currentPage = Integer.parseInt(pageNum);
		
		BoardDao dao = BoardDao.getInstance();
		//��ü ���ڵ� ��(�˻� ���ڵ��) ��ȯ
		int count = dao.getBoardCount(keyfield, keyword);
		
		//����¡ ó��
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"list.do");
		
		List<BoardDto> list = null;
		if(count>0) {
			list = dao.getListBoard(page.getStartCount(), page.getEndCount(), keyfield, keyword);
		}		
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.setAttribute("pagingHtml", page.getPagingHtml());
		
		return "/views/board/list.jsp";
	}
}
