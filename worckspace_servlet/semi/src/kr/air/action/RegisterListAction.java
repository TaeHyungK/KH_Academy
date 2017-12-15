package kr.air.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.air.dao.ManagerDao;
import kr.air.domain.ManagerDto;
import kr.controller.Action;
import kr.util.PagingUtil;
   
public class RegisterListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�˻� ó��
		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");
		
		if(keyfield == null) keyfield = "";
		if(keyword == null) keyword = "";
		
		//pageNum ó��(null�̸� 1�������� ó��)
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		
		int rowCount = 20;
		int pageCount = 10;
		int currentPage = Integer.parseInt(pageNum);
		
		//Dao ȣ��
		ManagerDao dao = ManagerDao.getInstance();
		//���ڵ� �� ��ȯ
		int count = dao.getReboardCount(keyfield, "");
		//PagingUtil ��ü ����
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"list.do");
		//��� ȣ��
		List<ManagerDto> list = null;
		if(count > 0) {
			list = dao.getListReboard(page.getStartCount(), page.getEndCount(), keyfield, keyword);
		}
		//request�� ����
		request.setAttribute("count",count);
		request.setAttribute("list", list);
		request.setAttribute("pagingHtml", page.getPagingHtml());
		
		System.out.println("count = " + count);
		System.out.println("list = " + list);
		
		return "/views/register/registerList.jsp";
	}

}





