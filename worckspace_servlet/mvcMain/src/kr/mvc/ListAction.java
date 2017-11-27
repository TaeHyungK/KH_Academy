package kr.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//�����͸� request�� ����
		req.setAttribute("message", "�Խ��� ����Դϴ�.");
		
		//JSP ��� ��ȯ
		return "/views/list.jsp";
	}

}
