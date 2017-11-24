package kr.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	}
	
	//�۾��� �޼ҵ�
	private void requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = req.getParameter("message");
		
		String result = null;
		if(message == null || message.equals("")) {
			result = "�ȳ��ϼ���!";
		}else if(message.equals("name")) {
			result = "�̸��� ȫ�浿�Դϴ�.";
		}else if(message.equals("age")) {
			result = "���̴� 20�� �Դϴ�.";
		}else {
			result = "������ ����!";
		}
		
		//�����͸� request�� ����
		req.setAttribute("result", result);
		
		//foward ������� view(jsp)�� ȣ��
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/messageView.jsp");
		dispatcher.forward(req, resp);
	}
	
}
