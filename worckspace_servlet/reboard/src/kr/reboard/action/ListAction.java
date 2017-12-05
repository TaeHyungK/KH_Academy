package kr.reboard.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardDto;
import kr.util.PagingUtil;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		//�˻� ó��
		/*String keyfield = req.getParameter("keyfield");
		String keyword = req.getParameter("keyword");

		if(keyfield == null) keyfield = "";
		if(keyword == null) keyword = "";*/
		String keyfield = "";
		String keyword = "";
		
		//pageNum ó��(null�̸� 1�������� ó��
		String pageNum = req.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";

		int rowCount = 20;
		int pageCount = 10;
		int currentPage = Integer.parseInt(pageNum);

		//BoardDao ȣ��
		BoardDao dao = BoardDao.getInstance();
		//���ڵ� �� ��ȯ
		int count = dao.getReboardCount(keyfield, keyword);

		//PagingUtil��ü ����
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage,count,rowCount,pageCount,"list.do");
		
		//��� ȣ��
		List<BoardDto> list = null;
		if(count>0) {
			list = dao.getListReboard(page.getStartCount(), page.getEndCount(), keyfield, keyword);
		}

		//request�� count, list, pagingHtml�� ����
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.setAttribute("pagingHtml", page.getPagingHtml());
		
		
		return "/views/reboard/list.jsp";
	}

}
