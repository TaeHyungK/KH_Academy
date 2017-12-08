package kr.reboard.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.reboard.dao.BoardDao;
import kr.reboard.domain.BoardReply;
import kr.util.PagingUtil;

public class ListReplyAjaxAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String,Object> map = 
				new HashMap<String,Object>();
		//������ ��ȣ
		String pageNum = 
				request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		//�θ�� ��ȣ
		int num = Integer.parseInt(
				request.getParameter("num"));
		
		int rowCount = 10;
		int pageCount = 10;
		int currentPage = Integer.parseInt(pageNum);
		
		BoardDao dao = BoardDao.getInstance();
		int count = dao.getReplyBoardCount(num);
		
		/*
		 * PagingUtil�� �̿��ؼ� ������ �� ���ڿ���
		 * ���ϴ� ���� �ƴ϶� ��� �������� ����¡
		 * ó���� ���� ���� rownum��ȣ�� �� rownum��ȣ��
		 * ����
		 */
		PagingUtil page = new PagingUtil(currentPage,
				count,rowCount,pageCount,null);
		
		List<BoardReply> list = null;
		if(count > 0) {
			list = dao.getListReplyBoard(
					page.getStartCount(),
					page.getEndCount(),
					num);
		}else {
			list = Collections.emptyList();
		}
		
		map.put("count", count);
		map.put("rowCount",rowCount);
		map.put("list", list);
		
		//JSON �����ͷ� ��ȯ
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(map);
		
		request.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}





