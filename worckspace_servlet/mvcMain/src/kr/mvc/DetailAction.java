package kr.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//�����͸� request�� ����
		req.setAttribute("message", "�Խ��� �󼼺���!");
		
		//JSP��� ��ȯ
		return "/views/detail.jsp";
	}

}
