package kr.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//�����Ϳ� request ����
		req.setAttribute("message", "�Խ��� ���� ����!!");
		
		return "views/update.jsp";
	}

}
