package kr.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//�����͸� request�� ����
		req.setAttribute("message", "�Խñ� �˻�!!");
		
		return "/views/search.jsp";
	}

}